package ucr.ac.ecci.ci1322.laboratorio1.model;

public class Student{
    int id;
    String name;
    String carnet;
    public Student(int id, String name, String carnet){
        this.id = id;
        this.name = name;
        this.carnet = carnet;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCarnet() {
        return carnet;
    }
}