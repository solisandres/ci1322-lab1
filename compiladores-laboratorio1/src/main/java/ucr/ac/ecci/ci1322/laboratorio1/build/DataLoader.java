package ucr.ac.ecci.ci1322.laboratorio1.build;

import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.*;//para HSSF sheet, row, cell
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import ucr.ac.ecci.ci1322.laboratorio1.core.book.service.BookService;
import ucr.ac.ecci.ci1322.laboratorio1.core.book.service.BookServiceImpl;
import ucr.ac.ecci.ci1322.laboratorio1.core.student.service.StudentService;
import ucr.ac.ecci.ci1322.laboratorio1.core.student.service.StudentServiceImpl;
import ucr.ac.ecci.ci1322.laboratorio1.model.Book;
import ucr.ac.ecci.ci1322.laboratorio1.model.Student;

//Carga datos de hoja de cálculo a base de datos.
public class DataLoader{

    static BookService bookService;
    static StudentService studentService;
    static HSSFDataFormatter dataFormatter = new HSSFDataFormatter(); // para obtener valor de celda como hilera

    //Inicializa servicios.
    public DataLoader(){
        bookService = new BookServiceImpl();
        studentService = new StudentServiceImpl();
    }


    //Carga cada fila de estudiantes para crear los objetos.
    public void loadStudents(HSSFSheet sheet){
        sheet.forEach( row -> {
            String id  = dataFormatter.formatCellValue(row.getCell(0));
            String name = dataFormatter.formatCellValue(row.getCell(1));
            String carnet = dataFormatter.formatCellValue(row.getCell(2));
            studentService.create(new Student(id, name, carnet));
        });
    }


    //Carga cada fila de libros para crear los objetos.
    public void loadBooks(HSSFSheet sheet){
        sheet.forEach( row -> {
            String id  = dataFormatter.formatCellValue(row.getCell(0));
            String title = dataFormatter.formatCellValue(row.getCell(1));
            String author = dataFormatter.formatCellValue(row.getCell(2));
            bookService.create(new Book(id, title, author));
        });
    }

    //Carga las hojas de cálculo formato xls.
    public static void main(String[] args){
        DataLoader dl = new DataLoader();
        FileInputStream fileIn = null;
        try{
            fileIn = new FileInputStream("./src/main/resources/workbook.xls");
            POIFSFileSystem fs = new POIFSFileSystem(fileIn);
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheetStudent = wb.getSheetAt(0);
            HSSFSheet sheetBook = wb.getSheetAt(1);
            dl.loadStudents(sheetStudent);
            dl.loadBooks(sheetBook);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}