package avaj_launcher.Tower;

import avaj_launcher.WeatherProvider.WeatherProvider;
import avaj_launcher.Aircraft.Coordinates;

public class WeatherTower extends Tower{

    public static String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentProvider(coordinates);
    }

    public void changeWeather() {
        this.conditionsChanged();
    }
}
