package seedu.volant.journal.model.entry;

import static seedu.volant.commons.util.StringUtil.formatDate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import seedu.volant.home.model.trip.Location;

/**
 * Represents an Entry in a journal.
 */
public class Entry {

    private String text;
    private LocalDate date;
    private LocalTime time;
    private Feeling feeling;
    private Weather weather;
    private Location location;

    /**
     * Constructs journal entry.
     * Date and time are automatically initialised to the date and time at which the user creates the journal entry.
     */
    public Entry(LocalDate date, LocalTime time) {
        // Initialises entry with user-input date and time.
        this.text = "";
        this.date = date;
        this.time = time;
        this.feeling = Feeling.NULL;
        this.weather = Weather.NULL;
        this.location = new Location("null");
    }

    /**
     * Temporary constructor for demonstration purposes, will remove later.
     */
    public Entry(LocalDate date, LocalTime time, String text, Feeling feeling, Weather weather, String location) {
        this.text = text;
        this.date = date;
        this.time = time;
        this.feeling = feeling;
        this.weather = weather;
        this.location = new Location(location);
    }


    public String getText() {
        return text;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm a");
        return time.format(formatter);
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDateAsString() {
        return formatDate(date);
    }

    public Location getLocation() {
        return location;
    }

    public String getLocationAsString() {
        return location.toString();
    }

    public Feeling getFeeling() {
        return feeling;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setFeeling(Feeling feeling) {
        this.feeling = feeling;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return getText();
    }
}