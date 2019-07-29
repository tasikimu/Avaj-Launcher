package avaj_launcher.Aircraft;

import avaj_launcher.Tower.WeatherTower;

public interface Flyable {
    public void updateConditions();

    public void registerTower(WeatherTower WeatherTower);
}
