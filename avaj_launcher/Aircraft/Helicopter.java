package avaj_launcher.Aircraft;

import avaj_launcher.Tower.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    //method

    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);

    }

    public void updateConditions() {

        String weather = WeatherTower.getWeather(this.coordinates);


        switch (weather){
            case "SUN": {
                WeatherTower.WriteToFile("Helicopter#" + this.name + "(" + this.id + ") : What a nice weather to chill under the shade");
                coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
            }
            case "RAIN": {
                weatherTower.WriteToFile("Helicopter#" + this.name + "(" + this.id + ") : Did u just have to rain this bad ");
                coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
            }
            case "FOG": {
                WeatherTower.WriteToFile("Helicopter#" + this.name + "(" + this.id + ") : Would be nice to just chill in this weather;");
                coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
            }
            case "SNOW" : {
                WeatherTower.WriteToFile("Helicopter#" + this.name + "(" + this.id + ") : I feeel soooo coooold;");
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
            }
        }

        if (coordinates.getHeight() <= 0){
            weatherTower.WriteToFile("Tower says:Helicopter#" + this.name + "(" + this.id + ")" + "landed and unregister from the tower.");
            weatherTower.unregister(this);
        }
        else if (coordinates.getHeight() > 10) {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 10);
        }


    }

    public void registerTower(WeatherTower weatherTower){
        weatherTower.WriteToFile("Tower says: Helicopter#" + this.name + "(" + this.id +")" + "registered to weather Tower.");
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }
}
