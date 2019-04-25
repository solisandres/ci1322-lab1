package ucr.ac.ecci.ci1322.laboratorio1.core.student.service;

import ucr.ac.ecci.ci1322.laboratorio1.core.student.dao.JdbcStudentService;
import ucr.ac.ecci.ci1322.laboratorio1.core.student.dao.StudentDao;
import ucr.ac.ecci.ci1322.laboratorio1.model.Student;

public class StudentServiceImpl implements StudentService{

    StudentDao studentDao;

    public StudentServiceImpl(){
        studentDao = new JdbcStudentService();
    }

    public Student findById(String id){
        return studentDao.findById(id);
    }
    public void create(Student entity){
        studentDao.create(entity);
    }
    public void update(Student entity){
        studentDao.update(entity);
    }
    public void remove(Student entity){
        studentDao.remove(entity);
    }
}