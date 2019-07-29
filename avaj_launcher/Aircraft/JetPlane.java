package avaj_launcher.Aircraft;

import avaj_launcher.Aircraft.Flyable;
import avaj_launcher.Tower.Tower;
import avaj_launcher.Tower.WeatherTower;

public class JetPlane extends  Aircraft implements Flyable {
    private WeatherTower weatherTower = new WeatherTower();

    //constructor

    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = WeatherTower.getWeather(this.coordinates);

        switch (weather){
            case "RAIN": {
                WeatherTower.WriteToFile("JetPlane#" + this.name + "(" + this.id + ") : THIS RAIN THOUGH");
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
                break;
            }
            case "SUN": {
                weatherTower.WriteToFile("JetPlane#" + this.name + "(" + this.id + ") : What a nice weather to have pictures");
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
                break;
            }
            case "FOG": {
                WeatherTower.WriteToFile("JetPlane#" + this.name + "(" + this.id + ") : ahhhh;");
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
                break;
            }
            case "SNOW" : {
                WeatherTower.WriteToFile("JetPlane#" + this.name + "(" + this.id + ") : Feel like I could do with ome coffee;");
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
                break;
            }
        }

        if (coordinates.getHeight() <= 0){
            weatherTower.WriteToFile("Tower says:JetPlane#" + this.name + "(" + this.id + ")" + "landed and unregister from the tower.");
            weatherTower.unregister(this);
        }
        else if (coordinates.getHeight() > 10) {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 10);
        }


    }

    public void registerTower(WeatherTower weatherTower){
        weatherTower.WriteToFile("Tower says: JetPlane#" + this.name + "(" + this.id +")" + "registered to weather Tower.");
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }
}
