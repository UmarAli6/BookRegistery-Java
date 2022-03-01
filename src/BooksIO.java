import Library.Book;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * Class for handling serialization of list of book from and to file
 * @author Rab_S & Umar_A
 */
public class BooksIO {

    public BooksIO() {
    }
    
    /**
     * Prints object list book to file, throws IOException
     * @param filename
     * @param books
     * @throws IOException 
     */
    public static void serializeToFile(String filename, List<Book> books) throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(books);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * Reads object list book from file and returns a List of books, throws IOException and ClassNotFoundException
     * @param filename
     * @return a {@code List<Book>} with books from file
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static List<Book> deSerializeFromFile(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(filename));
            List<Book> books = (List<Book>) in.readObject();
            return books;
        } finally {
            if (in != null) {
                in.close();
            }
        }
        
    }

}
