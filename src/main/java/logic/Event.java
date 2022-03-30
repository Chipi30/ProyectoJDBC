package logic;

public class Event {
    private int id;
    private String nombre;

    public Event() {
    }

    public Event(int id) {
        this.id = id;
    }

    public Event(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
