package seedu.volant.journal.model.entry;

import java.util.Comparator;

/**
 * Comparator for sorting by Feeling.
 */
public class FeelingComparator implements Comparator<Entry> {
    @Override
    public int compare(Entry e1, Entry e2) {
        Feeling f1 = e1.getFeeling();
        Feeling f2 = e2.getFeeling();
        if (!f1.equals(f2)) {
            return f1.compareTo(f2);
        } else {
            return new OldestDateTimeComparator().compare(e1, e2);
        }
    }
}
