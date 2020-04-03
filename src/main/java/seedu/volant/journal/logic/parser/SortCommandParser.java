package seedu.volant.journal.logic.parser;

import seedu.volant.commons.logic.parser.Parser;
import seedu.volant.commons.logic.parser.ParserUtil;
import seedu.volant.commons.logic.parser.exceptions.ParseException;
import seedu.volant.journal.logic.commands.SortCommand;
import seedu.volant.journal.model.entry.SortType;

/**
 * Parses input arguments and creates a new SortCommand object
 */
public class SortCommandParser implements Parser<SortCommand> {
    @Override
    public SortCommand parse(String userInput) throws ParseException {
        try {
            SortType sortType = ParserUtil.parseSortType(userInput);
            return new SortCommand(sortType);
        } catch (ParseException pe) {
            throw pe;
        }
    }
}
