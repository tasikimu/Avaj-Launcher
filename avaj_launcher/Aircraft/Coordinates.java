package avaj_launcher.Aircraft;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    //contructor
    Coordinates (int longitude, int latitude, int height){
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getHeight() {
        return this.height;
    }

    public int getLatitude() {

        return this.latitude;
    }

    public int getLongitude() {

        return this.longitude;
    }
}
