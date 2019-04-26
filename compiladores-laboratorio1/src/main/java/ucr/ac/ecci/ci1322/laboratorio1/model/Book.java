package ucr.ac.ecci.ci1322.laboratorio1.model;

public class Book{
    String id;
    String title;
    String author;

    public Book(String id, String title, String author){
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}