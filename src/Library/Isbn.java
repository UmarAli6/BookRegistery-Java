package Library;

import java.io.Serializable;

/**
 * Class representing an Isnb,
 * Implements the interface Serializable
 * @author Rab_S & Umar_A
 */
public class Isbn implements Serializable{
    private final String isbnStr;
    private static final String isbnPattern = "[0-9]{13}";
    
    private Isbn(String isbnStr) {
        this.isbnStr = isbnStr;
    }
    
    /**
     * Creates new Isbn for specified book
     * @param isbnStr
     * @return a {@code string} representing the ISBN if it matches the pattern
     * @throws IllegalArgumentException
     */
    public static Isbn createIsbn(String isbnStr) throws IllegalArgumentException {
        isbnStr = isbnStr.replace("-", "");
        
        if (!isbnStr.matches(isbnPattern)) throw new IllegalArgumentException("Wrong ISBN!: " + isbnStr + "ISBN must be 13 numbers!: ");
        
        return new Isbn(isbnStr);
    }
    
    /**
     * Get the Isbn
     * @return  a {@code String} with the Isbn
     */
    public String getIsbnStr() {
        return isbnStr;
    }

    @Override
    public String toString() {
        return "ISBN: " + isbnStr;
    }   
}