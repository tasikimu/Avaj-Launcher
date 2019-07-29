package avaj_launcher.Aircraft;

public class AircraftFactory {

    public static Flyable newAircraft (String type, String name, int longitude, int latitude, int height) {

        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        switch (type) {
            case "Baloon": {
                return new Baloon(name, coordinates);
            }

            case "JetPlane": {
                return new JetPlane(name, coordinates);
            }

            case "Helicopter": {
                return new Helicopter(name, coordinates);
            }

        }

        return null;

    }
}
