import Library.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        /*
        Book book1 = new Book("The Trial", 5, "9780805210408", Genre.DRAMA);
        Book book2 = new Book("A Game of Thrones", 5, "9780553103540", Genre.EPIC);
        Book book3 = new Book("1984", 4, "9780451524935", Genre.DRAMA);
        Book book4 = new Book("Dune", 5, "9780340960196", Genre.SCIENCE_FICTION);
        Book book5 = new Book("IT", 2, "9781473666948", Genre.HORROR);
        Book book6 = new Book("In Cold Blood", 3, "9780679745587", Genre.TRUE_CRIME);
        Book book7 = new Book("The Martian", 4, "9780804139021", Genre.SCIENCE_FICTION);
        Book book8 = new Book("Crime and Punishment", 5, "246-7975410448", Genre.DRAMA);
        Book book9 = new Book("The Autobiography of Malcolm X", 4, "9780345350688", Genre.AUTOBIOGRAPHY);
        Book book10 = new Book("Life after Life", 3, "9780712602730", Genre.EPIC);
        //Book book11 = new Book("Life after Life", 5, "9780552779685", Genre.DRAMA);
        //Book book12 = new Book("Life after Life", 1, "9781537617985", Genre.HORROR);
        Book book11 = new Book("The Life of Pi", 5, "9780552779685", Genre.DRAMA);
        Book book12 = new Book("Invisible Man", 1, "9781537617985", Genre.HORROR);
        
        Author author1 = new Author("Franz Kakfa", LocalDate.of(1883, Month.JULY, 3));
        Author author2 = new Author("George R.R. Martin", LocalDate.of(1948, Month.SEPTEMBER, 20));
        Author author3 = new Author("George Orwell", LocalDate.of(1903, Month.JUNE, 25));
        Author author4 = new Author("Frank Herbert", LocalDate.of(1920, Month.OCTOBER, 8));
        Author author5 = new Author("Stephen King", LocalDate.of(1947, Month.SEPTEMBER, 21));
        Author author6 = new Author("Truman Capote", LocalDate.of(1924, Month.SEPTEMBER, 30));
        Author author7 = new Author("Andy Weir", LocalDate.of(1972, Month.JUNE, 16));
        Author author8 = new Author("Fyodor Dostoevsky", LocalDate.of(1821, Month.NOVEMBER, 11));
        //Author author9 = new Author("Malcom X", LocalDate.of(1925, Month.FEBRUARY, 21));
        Author author99 = new Author("Alex Haley", LocalDate.of(1921, Month.AUGUST, 11));
        Author author10 = new Author("Raymond Moore", LocalDate.of(1944, Month.JUNE, 30));
        Author author11 = new Author("Kate Atkinson", LocalDate.of(1951, Month.DECEMBER, 20));
        Author author12 = new Author("Ronnie G. Anderson", LocalDate.of(1994, Month.APRIL, 1));
        
        book1.addAuthor(author1);
        book2.addAuthor(author2);
        book3.addAuthor(author3);
        book4.addAuthor(author4);
        book5.addAuthor(author5);
        book6.addAuthor(author6);
        book7.addAuthor(author7);
        book8.addAuthor(author8);
        
        //book9.addAuthor(author9);
        book9.addAuthor(author99);
        
        book10.addAuthor(author10);
        book11.addAuthor(author11);
        book12.addAuthor(author12);
        
        theCollection.addBook(book1);
        theCollection.addBook(book2);
        theCollection.addBook(book3);
        theCollection.addBook(book4);
        theCollection.addBook(book5);
        theCollection.addBook(book6);
        theCollection.addBook(book7);
        theCollection.addBook(book8);
        theCollection.addBook(book9);
        theCollection.addBook(book10);
        theCollection.addBook(book11);
        theCollection.addBook(book12);
        */
        
        
        Book book = new Book("The Trial", 4, "978-0805210408", Genre.AUTOBIOGRAPHY);
        Book book2 = new Book("Game Of Thrones", 2, "246-7975410448", Genre.DRAMA);
        Book book3 = new Book("Game Of Thrones", 5, "246-7975410448", Genre.DRAMA);
        Book book4 = new Book("1984", 4, "246-7975410448", Genre.DRAMA);
        CollectionOfBooks theBooks = new CollectionOfBooks();
        
        Author author = new Author("Franz Kakfa", LocalDate.of(1883, Month.JULY, 3));
        Author author2 = new Author("George Orwell", LocalDate.of(2001, Month.APRIL, 7));
        Author author3 = new Author("Peter Lak", LocalDate.of(1942, Month.JANUARY, 25));
        Author author4 = new Author("Fat Guy", LocalDate.of(1788, Month.SEPTEMBER, 11));
        
        book.addAuthor(author);
        
        book2.addAuthor(author4);
        
        book3.addAuthor(author3);
        book3.addAuthor(author4);
        
        book4.addAuthor(author2);
        
        //book2.addAuthor(author4);
        //book3.addAuthor(author4);
        //book4.addAuthor(author4);
        
        theBooks.addBook(book);
        theBooks.addBook(book2);
        theBooks.addBook(book3);
        theBooks.addBook(book4);
        
        //System.out.println(theBooks.toString());
        
        
        
        
        //book.addAuthor(author2);
        
        /*System.out.println(book.equals(book2));
        //System.out.println(book.toString() + "\n\n");*/
        
        //System.out.println(theBooks.searchTitle("a").toString());
        System.out.println(theBooks.searchAuthor("Fat").toString());
        //System.out.println(theBooks.searchIsbn("9780805210408").toString());
        
        //theBooks.removeBook(book2);
        
        //System.out.println(theBooks.toString());
        
    }
}
