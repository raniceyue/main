package seedu.volant.journal.model.entry;

/**
 * Represents SortTypes for SortCommand in Journal.
 */
public enum SortType {
    NEW, OLD, LOCATION, FEELING;
    public static final String MESSAGE_CONSTRAINTS = "I'm not sure how to sort that way, sorry :( \n"
            + "Here are the available sort types: \n"
            + "OLD, NEW, LOCATION, FEELING";
}
