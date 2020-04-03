package seedu.volant.home.model.trip;

import java.util.Comparator;

/**
 * Compares 2 trips for sorting in chronological order, with the latest date first.
 */
public class TripDateComparator implements Comparator<Trip> {

    @Override
    public int compare(Trip t1, Trip t2) {
        // checking if t1 starting date is past t2 starting date
        if (t1.getDateRange().from.isAfter(t2.getDateRange().from)) {
            return -1;
        } else {
            return 1;
        }
    }
}
