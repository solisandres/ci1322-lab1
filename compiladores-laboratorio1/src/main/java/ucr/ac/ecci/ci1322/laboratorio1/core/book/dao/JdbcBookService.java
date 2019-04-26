package ucr.ac.ecci.ci1322.laboratorio1.core.book.dao;

import ucr.ac.ecci.ci1322.laboratorio1.model.Book;
import java.sql.*;

//Ejecuta sentencias SQL para manipular objetos libro en base de datos.
public class JdbcBookService implements BookDao{
    Connection connection;

    //Crea conexión con la base de datos.
    public JdbcBookService() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/automatas", "root", "password");
        } catch (Exception e) {
            e.printStackTrace();;
        }
    }

    //Retorna objeto libro de la base de datos.
    public Book findById(String id) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM books WHERE id = " + id + ";");
            rs.next();
            String bookId = rs.getString(1);
            String bookTitle = rs.getString(2);
            String bookAuthor = rs.getString(3);

            return new Book(bookId, bookTitle, bookAuthor);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
    }

    //Crea objeto libro en la base de datos.
    public void create(Book entity){
        try{
            String query = "INSERT INTO books  VALUES (?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, entity.getId());
            preparedStmt.setString (2, entity.getTitle());
            preparedStmt.setString (3, entity.getAuthor());
            preparedStmt.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void update(Book entity){}
    public void remove(Book entity){}
}