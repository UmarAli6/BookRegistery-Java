package Library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents a book.
 * Implements the interfaces Comparable and Serializable
 * @author Rab_S & Umar_A
 */
public class Book implements Comparable<Book>, Serializable {

    private final String title;
    private final int rating;
    private ArrayList<Author> theAuthors;
    private final Genre genre;
    private final Isbn isbn;
    
    /**
     * Create a new Book object.
     * @param title an {@code String] representing title of the book.
     * @param rating an {@code int] representing the rating of the book.
     * @param isbnStr an {@code String] representing the ISBN of the book.
     * @param genre an {@code enum] of object type Genre representing the genre of the book.
     */
    public Book(String title, int rating, String isbnStr, Genre genre) {
        this.title = title;
        this.rating = rating;
        this.theAuthors = new ArrayList<>();
        this.isbn = Isbn.createIsbn(isbnStr);
        this.genre = genre;
    }
    
    /**
     * Add author to the list.
     * @param author author object to add.
     */
    public void addAuthor(Author author) {
        theAuthors.add(author);
    }
    
    /**
     * Add multiple authors to the list.
     * @param theAuthors the list of authors to add.
     */
    public void addAuthors(List<Author> theAuthors) {
        theAuthors.addAll(theAuthors);
    }
    
    /**
     * Get the title.
     * @return a {@code String} with the title.
     */
    public String getTitle() {
        return title;
    }
    /**
     * Get the rating.
     * @return an {@code int} with the rating.
     */
    public int getRating() {
        return rating;
    }
    
    /**
     * Get the author.
     * @param index
     * @return an {@code Author} object with the author at the specified index.
     */
    public Author getAuthor(int index) {
        return theAuthors.get(index);
    }
    
    /**
     * Returns a shallow copy of this {@code ArrayList} instance.
     * @return a clone of this {@code ArrayList} instance
     */
    public List<Author> getAuthors() {
        ArrayList<Author> temp = (ArrayList<Author>) theAuthors.clone();
        return temp;
    }
    
    /**
     * Get the genre.
     * @return a {@code Genre} object of the genre.
     */
    public Genre getGenre() {
        return genre;
    }
    
    /**
     * Get the value of the genre.
     * @return an {@code int} with the value of the genre.
     */
    public int getGenreValue() {
        return genre.getIndex();
    }
    
    /**
     * Get the ISBN.
     * @return an {@code Isbn} object of the Isbn.
     */
    public Isbn getIsbn() {
        return isbn;
    }

    @Override
    /**
     * Overrides Comparable.compareTo by implementing compareTo by two fields.
     * @param   o the {@code Book} object to be compared with.
     * @return  a positive or negative {@code int} if the title of the argument 
     *          Book is of higher or lower alphabetically order than the object 
     *          that called the method. If the titles are the same, returns an
     *          {@code int} with the difference between ratings of the two Book
     *          objects.
     */
    public int compareTo(Book o) {
        if (!equals(o)) {
            return this.getTitle().toUpperCase().compareTo(o.getTitle().toUpperCase());
        } else {
            return o.getRating()-this.getRating();
        }
    }
    
    @Override
    /**
     * Overrides Object.equals, equals returns true only if compareTo returns 0.
     * @param   o the {@code Book} object to be compared with.
     * @return  {@code true} if the parameter is an instance of Book object and
     *          the titles are the same. Else returns {@code false}.
     */
    public boolean equals(Object o) {
        if (o instanceof Book) {
            return this.getTitle().toUpperCase().compareTo(((Book) o).getTitle().toUpperCase()) == 0;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String info = "Book Title: " + title + "\nAuthor(s): ";
        
        for (int i = 0; i < theAuthors.size(); i++) {
            info += theAuthors.get(i).toString();
            info += ", ";
        }
        info +="\nRating: " + rating + "\nGenre: " + genre.toString() + "\nISBN: " + isbn.getIsbnStr();
        return info;
    }
}