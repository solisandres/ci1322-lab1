package ucr.ac.ecci.ci1322.laboratorio1.core.book.dao;
import ucr.ac.ecci.ci1322.laboratorio1.model.Book;

import java.sql.*;
public class JdbcBookService implements BookDao{
    Connection connection;
    public JdbcBookService() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/automatas", "root", "password");
        } catch (Exception e) {
            e.printStackTrace();;
        }
    }
    public Book findById(String id) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM books WHERE id = " + id);
            int bookId = rs.getInt("id");
            String bookTitle = rs.getString("title");
            String bookAuthor = rs.getString("author");

            return new Book(bookId, bookTitle, bookAuthor);
        } catch (Exception e) {
            e.printStackTrace();;
            throw new IllegalArgumentException();
        }
    }

    public void create(Book entity){
        try{
            String query = " INSERT INTO books  VALUES (?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt (1, entity.getId());
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