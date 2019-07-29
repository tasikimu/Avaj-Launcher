package avaj_launcher.Aircraft;

import avaj_launcher.Tower.Tower;
import avaj_launcher.Tower.WeatherTower;

public class Baloon extends Aircraft implements Flyable{
    private WeatherTower weatherTower = new WeatherTower();

    //method
    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = WeatherTower.getWeather(this.coordinates);

        switch (weather){
            case "RAIN": {
                WeatherTower.WriteToFile("Baloon#" + this.name + "(" + this.id + ") : Why did u have to rain so bad");
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
            }
            case "SUN": {
                weatherTower.WriteToFile("Baloon#" + this.name + "(" + this.id + ") : This is a nice weather, lets enjoy and take pictures");
                coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
            }
            case "FOG": {
                WeatherTower.WriteToFile("Baloon#" + this.name + "(" + this.id + ") : the weather is good for landing");
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
            }
            case "SNOW" : {
                WeatherTower.WriteToFile("Baloon#" + this.name + "(" + this.id + ") : Ohhh I so love when it's snowing;");
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
            }
        }
        if (coordinates.getHeight() <= 0){
            weatherTower.WriteToFile("Tower says:Baloon#" + this.name + "(" + this.id + ")" + "landed and unregister from the tower.");
            weatherTower.unregister(this);
        }
        else if(coordinates.getHeight() > 100){
            coordinates =  new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);
        }

    }

    public void registerTower(WeatherTower weatherTower){
        weatherTower.WriteToFile("Tower says: Baloon#" + this.name + "(" + this.id +")" + "registered to weather Tower.");
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }
}
