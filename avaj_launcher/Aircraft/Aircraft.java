package avaj_launcher.Aircraft;

//import Coordinates;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 1;

    //contructor

    protected Aircraft (String name, Coordinates coordinates){
        this.id = this.nextId();
        this.name = name;
        this.coordinates = coordinates;

    }
    private long nextId()  {
        return (idCounter++);
    }
}
