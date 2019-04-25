package ucr.ac.ecci.ci1322.laboratorio1.core.book.service;

import ucr.ac.ecci.ci1322.laboratorio1.core.book.dao.BookDao;
import ucr.ac.ecci.ci1322.laboratorio1.core.book.dao.JdbcBookService;
import ucr.ac.ecci.ci1322.laboratorio1.model.Book;

public class BookServiceImpl implements BookService{

    BookDao bookDao;

    public BookServiceImpl(){
        bookDao = new JdbcBookService();
    }

    public Book findById(String id){
        return bookDao.findById(id);
    }
    public void create(Book entity){
        bookDao.create(entity);
    }
    public void update(Book entity){
        bookDao.update(entity);
    }
    public void remove(Book entity){
        bookDao.remove(entity);
    }
}