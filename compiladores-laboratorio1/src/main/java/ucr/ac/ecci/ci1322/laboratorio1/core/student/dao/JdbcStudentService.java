package ucr.ac.ecci.ci1322.laboratorio1.core.student.dao;

import ucr.ac.ecci.ci1322.laboratorio1.model.Student;
import java.sql.*;

//Ejecuta sentencias SQL para manipular objetos libro en base de datos.
public class JdbcStudentService implements StudentDao{
    Connection connection;

    //Crea conexión con la base de datos.
    public JdbcStudentService(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/automatas","root","password");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //Retorna objeto estudiante de la base de datos.
    public Student findById(String id){
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM students WHERE id = " + id );
            String studentId = rs.getString("id");
            String studentName = rs.getString("name");
            String studentCarnet = rs.getString("carnet");

            Student student = new Student(studentId, studentName, studentCarnet);
            return student;
        }catch(Exception e){
            e.printStackTrace();;
            throw new IllegalArgumentException();
        }
    }

    //Crea objeto libro en la base de datos.
    public void create(Student entity){
        try{
            String query = " INSERT INTO students  VALUES (?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, entity.getId());
            preparedStmt.setString (2, entity.getName());
            preparedStmt.setString (3, entity.getCarnet());
            preparedStmt.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void update(Student entity){}
    public void remove(Student entity){}
}