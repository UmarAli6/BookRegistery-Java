package Library;

/**
 * Enum representing genre values for a book
 * @author Rab_S & Umar_A
 */
public enum Genre {
    DRAMA(1), TRUE_CRIME(2), HORROR (3), SCIENCE_FICTION(4), EPIC(5), AUTOBIOGRAPHY(6);
    
   public int getIndex() {
        return index;
    }

    private final int index;

    private Genre (int index) {
        this.index = index;
    }
}
