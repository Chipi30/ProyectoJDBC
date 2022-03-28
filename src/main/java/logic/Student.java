package logic;

public class Student {
    private int ID;
    private String name;
    private String evento;
    private int curso;
    private String diciplina;
    private String posicion;

    public Student(int ID, String name, String evento, int curso, String diciplina, String posicion) {
        this.ID = ID;
        this.name = name;
        this.evento = evento;
        this.curso = curso;
        this.diciplina = diciplina;
        this.posicion = posicion;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public String getDiciplina() {
        return diciplina;
    }

    public void setDiciplina(String diciplina) {
        this.diciplina = diciplina;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", evento='" + evento + '\'' +
                ", curso=" + curso +
                ", diciplina='" + diciplina + '\'' +
                ", posicion='" + posicion + '\'' +
                '}';
    }
}
