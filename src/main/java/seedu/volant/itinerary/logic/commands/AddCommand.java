package seedu.volant.itinerary.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.volant.commons.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.volant.commons.logic.parser.CliSyntax.PREFIX_LOCATION;
import static seedu.volant.commons.logic.parser.CliSyntax.PREFIX_TIME;
import static seedu.volant.commons.logic.parser.CliSyntax.PREFIX_TITLE;

import seedu.volant.commons.logic.commands.Command;
import seedu.volant.commons.logic.commands.CommandResult;
import seedu.volant.commons.logic.commands.exceptions.CommandException;
import seedu.volant.commons.model.Model;
import seedu.volant.itinerary.model.ItineraryModelManager;
import seedu.volant.itinerary.model.activity.Activity;

/**
 * Adds a activity to activity list.
 */
public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds an activity to the itinerary.\n"
            + "Parameters: \n"
            + PREFIX_TITLE + "TITLE "
            + PREFIX_LOCATION + "LOCATION "
            + PREFIX_DATE + "DATE "
            + PREFIX_TIME + "TIME \n"

            + "Example: " + COMMAND_WORD + " "
            + PREFIX_TITLE + "Visit World Trade Centre "
            + PREFIX_LOCATION + "New York "
            + PREFIX_DATE + "05-03-2020 "
            + PREFIX_TIME + "09:00";

    public static final String MESSAGE_SUCCESS = "New activity added: %1$s";
    public static final String MESSAGE_DUPLICATE_ITEM = "This activity already exists in your itinerary.";

    private final Activity toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Trip}
     */
    public AddCommand(Activity activity) {
        requireNonNull(activity);
        toAdd = activity;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        ItineraryModelManager itineraryModel = ((ItineraryModelManager) model);
        if (itineraryModel.hasActivity(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_ITEM);
        }

        itineraryModel.addActivity(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddCommand // instanceof handles nulls
                && toAdd.equals(((AddCommand) other).toAdd));
    }
}

