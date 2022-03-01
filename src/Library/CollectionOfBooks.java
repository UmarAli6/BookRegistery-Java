package Library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class representing a list (library) of books and methods for adding, removing and sorting books etc.
 * @author Rab_S & Umar_A
 */
public class CollectionOfBooks {
    private ArrayList<Book> theBooks;
    
    public CollectionOfBooks() {
        this.theBooks = new ArrayList<>();
    }
    
    /**
     * Adds a finished book to the list of books loops and adds authors to the list of authors in book class
     * @param book 
     */
    public void addBook(Book book) { 
        theBooks.add(new Book(book.getTitle(), book.getRating(), book.getIsbn().getIsbnStr(), book.getGenre()));
        
        for (int i = 0; i < book.getAuthors().size(); i++) {    
            theBooks.get(theBooks.size()-1).addAuthor(book.getAuthors().get(i));
        }
    }
    
    /**
     * Returns a shallow copy of this {@code ArrayList} instance.
     * @return a clone of this {@code ArrayList} instance
     */
    public List<Book> getTheBooks() {
        ArrayList<Book> temp = (ArrayList<Book>) theBooks.clone();
        return temp;
    }
    
    /**
     * Removes the book specified by the parameter.
     * @param book object of {@code Book} to remove.
     * @throws IllegalArgumentException
     */
    public void removeBook(Book book) {
        theBooks.remove(book);
    }
    
    /**
     * Sort theBooks.
     * @return a sorted sorted @code List} theBooks.
     */
    public List<Book> sortList() {
        Collections.sort(theBooks);
        return theBooks;
    }
    
    /**
     * Searches for the Title specified by the parameter.
     * @param keyWord the {@code String} of the Title to be searched for.
     * @return a sorted {@code ArrayList} with the search results.
     */
    public List<Book> searchTitle(String keyWord) {
        ArrayList<Book> tmp = new ArrayList<>();
        
        for(int i = 0; i < theBooks.size(); i++) {
            if (theBooks.get(i).getTitle().trim().toUpperCase().contains(keyWord.trim().toUpperCase())) {
                tmp.add(theBooks.get(i));
            }
        }
        
        Collections.sort(tmp);
        return tmp;
    }
    
    /**
     * Searches for the Author specified by the parameter.
     * @param keyWord the {@code String} of the Author to be searched for.
     * @return a sorted {@code ArrayList} with the search results.
     */
    public List<Book> searchAuthor(String keyWord){
        ArrayList<Book> tmp = new ArrayList<>();
        
        for (int i = 0; i < theBooks.size(); i++) {
            for (int j = 0; j < theBooks.get(i).getAuthors().size(); j++){
                if(theBooks.get(i).getAuthors().get(j).getName().trim().toUpperCase().contains(keyWord.trim().toUpperCase())){
                    tmp.add(theBooks.get(i));
                }
            }
        }
        Collections.sort(tmp);
        return tmp;
    }
    
    /**
     * Searches for the ISBN specified by the parameter.
     * @param keyword the {@code String} of the ISBN to be searched for.
     * @return a sorted {@code ArrayList} with the search results.
     */
    public List<Book> searchIsbn(String keyword) {
        ArrayList<Book> tmp = new ArrayList<>();
        
        for(int i = 0; i < theBooks.size(); i++) {
            if (theBooks.get(i).getIsbn().getIsbnStr().contains(keyword.trim().replace("-", ";"))) {
                tmp.add(theBooks.get(i));
            }
        }
        Collections.sort(tmp);
        return tmp;
    }
    
    
    @Override
    public String toString() {
        
        //String info = "The Books:\n\n";
        String info = "";
        //info = String.format(info, args)
        //info += "Title        Author(s)        Rating        Genre        ISBN\n";
        
        /*for (int i = 0; i < theBooks.size(); i++) {
            info += theBooks.get(i).getTitle() + theBooks.get(i).getAuthors() + 
                    theBooks.get(i).getRating() + theBooks.get(i).getGenre() + 
                    theBooks.get(i).getIsbn();
            info += "\n";
        }*/
        //info += "        ";
        
        for (int i = 0; i < theBooks.size(); i++) {
            info += theBooks.get(i);
            info += "\n\n";
        }
        
        return info;
    }
}