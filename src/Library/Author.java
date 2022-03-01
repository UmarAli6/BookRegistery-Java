package Library;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Class that represents an author of a book with the object type Book.
 * Implements the interface Serializable,
 * @author Rab_S & Umar_A
 */
public class Author implements Serializable {
    
    private final String name;
    private final LocalDate dateOfBirth;
    
    /**
     * Create a new Author object.
     * @param name an {@code String] representing name of the author.
     * @param dateOfBirth an {@code LocalDate] object representing the rating of the book.
     */    
    public Author(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }
    
    /**
    * Get name of the author
    * @return a {@code String} of the Author name
    */
    public String getName() {
        return name;
    }

    /**
     * Get the author date of birth
     * @return a {@code LocalDate} of the Authors date of birth
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return getName() + " Date Of Birth: " + getDateOfBirth();
    }

    
}
