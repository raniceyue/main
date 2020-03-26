package seedu.volant.itinerary.model.activity;

import static seedu.volant.commons.util.StringUtil.formatDate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import seedu.volant.home.model.trip.Location;

/**
 * Represents an activity in an activity list.
 */
public class Activity {
    private Title title;
    private LocalDate date;
    private LocalTime time;
    private Location location;


    public Activity(Title title, LocalDate date, LocalTime time, Location location) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public String getTitle() {
        return title.toString();
    }

    public String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm a");
        return time.format(formatter);
    }

    public String getDate() {
        return formatDate(date);
    }

    public String getLocation() {
        return location.toString();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getTitle())
                .append("\nLocation: ")
                .append(this.getTitle())
                .append("\nDate: ")
                .append(this.getDate())
                .append("\nTime: ")
                .append(this.getTime());
        return builder.toString();
    }

    @Override
    public boolean equals(Object other) {
        boolean result = false;
        if (other == this) {
            result = true;
        }
        if (!(other instanceof Activity)) {
            result = false;
        } else if ((this.getDate().equals(((Activity) other).getDate()))
            && (this.getTime().equals(((Activity) other).getTime()))) {
            result = true;
        }

        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.title, this.date, this.time, this.location);
    }
}