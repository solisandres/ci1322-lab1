package ucr.ac.ecci.ci1322.laboratorio1.build;

import ucr.ac.ecci.ci1322.laboratorio1.core.book.service.BookService;
import ucr.ac.ecci.ci1322.laboratorio1.core.book.service.BookServiceImpl;
import ucr.ac.ecci.ci1322.laboratorio1.model.Book;
import java.util.Scanner;

//Busca libro por id, imprime los datos.
public class PrintBook{
    public static void main (String[] args){
        try{
            BookService bookService = new BookServiceImpl();
            System.out.println("enter id: ");
            Scanner scanner = new Scanner(System.in);
            String id = scanner.nextLine();
            Book book = bookService.findById(id);
            System.out.println("id: " + book.getId() +
                    "\ntitle: " + book.getTitle() +
                    "\nauthor: " +book.getAuthor()) ;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}