import java.util.Scanner;
import Library.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class UserInterface {
    private CollectionOfBooks theCollection;
    private final Scanner scan;

    public UserInterface() {
        theCollection = new CollectionOfBooks();
        scan = new Scanner(System.in);
    }

    public void run() {
        String filename = "lib.ser";
        addBooksFromFile(filename);   //Uncomment if you have a lib.ser file
                                        //in root to read from. Add books when 
                                        //running UI for the first time and then
                                        //quit. A lib.ser should appear in root.
                                        //Uncomment and it will read in from the
                                        //libe.ser file.

        int answer;

        do {            
            try {
                printMenu();
                System.out.print("Enter choice: ");
                answer = scan.nextInt();
                scan.nextLine();
            } catch (java.util.InputMismatchException e) {
                answer = 0;
                scan.nextLine();
            }

            switch (answer) {
                case 1:
                    System.out.println("\nAdd book\n");
                    addBook();
                    break;
                case 2:
                    System.out.println("\nRemove Books\n");
                    removeBook();
                    break;
                case 3:
                    while (true) {
                        printSearchMenu();
                        System.out.print("What do you want to search by?: ");
                        int choice;
                        
                        try {
                            choice = scan.nextInt();
                            scan.nextLine();
                        } catch (java.util.InputMismatchException e) {
                            choice = 0;
                            scan.nextLine();
                        }
                        
                        if (choice == 1) {
                            searchByTitle(setKeyword(choice));
                            break;
                        } else if (choice == 2) {
                            searchByAuthor(setKeyword(choice));
                            break;
                        } else if (choice == 3) {
                            searchByIsbn(setKeyword(choice));
                            break;
                        } else {
                            System.out.println("\nWrong input, try again!\n");
                        }
                    }
                    break;
                case 4:
                    System.out.println("\nPrint all Books\n");
                    theCollection.sortList();
                    System.out.println(theCollection.toString());
                    break;
                case 5:
                    System.out.println("\nQuit and write to file\n");
                    serToFile(filename, theCollection);
                    break;
                default:
                    System.out.println("\nUnknown command, try again!\n");
            }
        } while (answer != 5);
    }

    public void addBook() {
        String name, isbn;
        int rating, choiceOfGenre;
        Genre genre;

        System.out.print("Enter title of book: ");
        name = scan.nextLine();
        
        
        
        do {
            System.out.print("\nRate the book (1-5): ");
            try {
                rating = scan.nextInt();
                scan.nextLine();
            } catch (java.util.InputMismatchException e) {
                rating = 0;
                scan.nextLine();
            }
            
            if (rating < 1 || rating > 5) {
                System.out.println("\nWrong input, try again!");
            }
        } while (rating < 1 || rating > 5);
        
        System.out.println();
        
        do {
            for (Genre gen : Genre.values()) {
                System.out.print(gen + " (" + gen.getIndex() + ")   ");
            }
            System.out.print("\n\nChoose one of the genres above: ");

            try {
                choiceOfGenre = scan.nextInt();
                scan.nextLine();
            } catch (java.util.InputMismatchException e) {
                choiceOfGenre = 0;
                scan.nextLine();
            }
            
            switch (choiceOfGenre) {
                case 1:
                    genre = Genre.DRAMA;
                    break;
                case 2:
                    genre = Genre.TRUE_CRIME;
                    break;
                case 3:
                    genre = Genre.HORROR;
                    break;
                case 4:
                    genre = Genre.SCIENCE_FICTION;
                    break;
                case 5:
                    genre = Genre.EPIC;
                    break;
                case 6:
                    genre = Genre.AUTOBIOGRAPHY;
                    break;
                default:
                    System.out.println("\nWrong input, try again!\n");
                    genre = null;
                    break;
            }
        } while (genre == null);
        
        System.out.print("\nEnter the ISBN: ");
        isbn = scan.nextLine();
        
        Book book;
        while (true) {
            try {
                book = new Book(name, rating, isbn, genre);
                break;
            } catch (IllegalArgumentException e) {
                System.out.print("\nWrong ISBN input! Enter correct ISBN: ");
                isbn = scan.nextLine();
            }
        }

        String enter;
        System.out.print("\nEnter the name of the author(s) (enter X when you are done): ");

        do {
            enter = scan.nextLine();

            if (!enter.equalsIgnoreCase("x")) {
                Author author = new Author(enter, LocalDate.now());
                book.addAuthor(author);
            }

        } while (!enter.equalsIgnoreCase("x"));

        theCollection.addBook(book);
    }

    public void removeBook() {
        ArrayList<Book> toRemove;
        String bookToRemove;

        System.out.print("Enter the title of the book you want to delete: ");
        
        do {
            
            bookToRemove = scan.nextLine();
            toRemove = (ArrayList<Book>) theCollection.searchTitle(bookToRemove);

            if (toRemove.size() == 1) {
                System.out.println("The book: " + toRemove.get(0).getTitle() + " has been deleted");
                theCollection.removeBook(toRemove.get(0));
            } else if (toRemove.size() > 1) {
                System.out.println("\nSearch Result\n");
                
                for (int i = 0; i < toRemove.size(); i++) {
                     System.out.println(toRemove.get(i).toString() + "\n");
                }
                
                System.out.print("Multiple results found! Please specify your search further or input ISBN!: ");
            
            } else if (bookToRemove.trim().replace("-", "").length() == 13 && bookToRemove.trim().replace("-", "").contains("[a-zA-Z]+") == false) {
                toRemove = (ArrayList<Book>) theCollection.searchIsbn(bookToRemove);
                System.out.println("\nThe book: " + toRemove.get(0).getTitle() + " has been deleted\n\n\n\n");
                theCollection.removeBook(toRemove.get(0));
                
            } else {
                System.out.println("\nNo results found. Try again.\n");
                System.out.print("Enter the title of the book you want to delete: ");
            }
        } while (toRemove.size() != 1);
    }

    public String setKeyword(int choice) {
        String keyword = "";
        
        switch (choice) {
            case 1:
                System.out.print("Enter title: ");
                keyword = scan.nextLine();
                break;
            case 2:
                System.out.print("Enter author: ");
                keyword = scan.nextLine();
                break;
            case 3:
                System.out.print("Enter ISBN: ");
                keyword = scan.nextLine();
                break;
        }
        return keyword;
    }
    
    public void searchByTitle(String keyword) {
        ArrayList<Book> searched;
        
        searched = (ArrayList<Book>) theCollection.searchTitle(keyword);
        
        if (!searched.isEmpty()) {
            System.out.println("\nThe result(s): \n");

            for (int i = 0; i < searched.size(); i++) {
                System.out.print("Book title: " + searched.get(i).getTitle());
                System.out.print("\nAuthors: " + searched.get(i).getAuthors());
                System.out.print("\nRating: " + searched.get(i).getRating());
                System.out.print("\nGenre: " + searched.get(i).getGenre());
                System.out.print("\nISBN: " + searched.get(i).getIsbn().getIsbnStr() + "\n\n");
            }
        } else {
            System.out.println("\n\nNo results found. Returning to menu.\n\n");
        }

    }
    
    public void searchByAuthor(String keyword) {
        ArrayList<Book> searched;
        
        searched = (ArrayList<Book>) theCollection.searchAuthor(keyword);
        
        if (!searched.isEmpty()) {
            System.out.println("\nThe result(s): \n");

            ArrayList<Book> tmp = new ArrayList<>();

            System.out.print("Book title: " + searched.get(0).getTitle());
            System.out.print("\nAuthors: " + searched.get(0).getAuthors());
            System.out.print("\nRating: " + searched.get(0).getRating());
            System.out.print("\nGenre: " + searched.get(0).getGenre());
            System.out.print("\nISBN: " + searched.get(0).getIsbn().getIsbnStr() + "\n\n");
            tmp.add(searched.get(0));
            
            for (int i = 0, j = 1; i < searched.size() - 1; i++, j++) {
                if (!tmp.get(i).equals(searched.get(j))) {
                    System.out.print("Book title: " + searched.get(j).getTitle());
                    System.out.print("\nAuthors: " + searched.get(j).getAuthors());
                    System.out.print("\nRating: " + searched.get(j).getRating());
                    System.out.print("\nGenre: " + searched.get(j).getGenre());
                    System.out.print("\nISBN: " + searched.get(j).getIsbn().getIsbnStr() + "\n\n");
                    tmp.add(searched.get(j));
                }
            }
        } else {
            System.out.println("\n\nNo results found. Returning to menu.\n\n");
        }
    }
    
    public void searchByIsbn(String keyword) {
        ArrayList<Book> searched;
        
        searched = (ArrayList<Book>) theCollection.searchIsbn(keyword);
        
        if (!searched.isEmpty()) {
            System.out.println("\nThe result(s): \n");

            for (int i = 0; i < searched.size(); i++) {
                System.out.print("Book title: " + searched.get(i).getTitle());
                System.out.print("\nAuthors: " + searched.get(i).getAuthors());
                System.out.print("\nRating: " + searched.get(i).getRating());
                System.out.print("\nGenre: " + searched.get(i).getGenre());
                System.out.print("\nISBN: " + searched.get(i).getIsbn().getIsbnStr() + "\n\n");
            }
        } else {
            System.out.println("\n\nNo results found. Returning to menu.\n\n");
        }
    }

    public void addBooksFromFile(String filename) {
        List<Book> books = deSerFromFile(filename);

        for (int i = 0; i < books.size(); i++) {
            theCollection.addBook(books.get(i));
        }
    }

    public void serToFile(String filename, CollectionOfBooks theCollection) {
        try {
            BooksIO.serializeToFile(filename, theCollection.getTheBooks());
        } catch (IOException ex) {
            System.out.println(ex.toString());
            System.out.println("Returning4"
                    + " to menu");
        }
    }

    public List<Book> deSerFromFile(String filename) {
        try {
            return BooksIO.deSerializeFromFile(filename);
        } catch (IOException ex) {
            System.out.println(ex.toString());
            System.out.println("Returning to menu");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
            System.out.println("Class not found");
        }
        return null;
    }

    public void printMenu() {
        System.out.println("\n-----------Menu-----------");
        System.out.println("1: Add Book");
        System.out.println("2: Remove Book");
        System.out.println("3: Search for Book");
        System.out.println("4: Print all Books");
        System.out.println("5: Quit and write to file");
        System.out.println("--------------------------");
    }

    public void printSearchMenu() {
        System.out.println("\n------Search For Book------");
        System.out.println("1: Title");
        System.out.println("2: Author(s)");
        System.out.println("3: ISBN");
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.run();
    }
}