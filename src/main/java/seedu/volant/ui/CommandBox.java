package seedu.volant.ui;

import java.util.Arrays;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import seedu.volant.commons.logic.Logic;
import seedu.volant.commons.logic.commands.CommandResult;
import seedu.volant.commons.logic.commands.exceptions.CommandException;
import seedu.volant.commons.logic.parser.exceptions.ParseException;

/**
 * The UI component that is responsible for receiving user command inputs.
 */
public class CommandBox extends UiPart<Region> {

    public static final String ERROR_STYLE_CLASS = "error";
    private static final String FXML = "CommandBox.fxml";
    private static final List<String> buttonColours = Arrays.asList("-fx-background-color: #ff3e3e;",
            "-fx-background-color: #fe9d2e;", "-fx-background-color: #f1f951;", "-fx-background-color: #7af951;",
            "-fx-background-color: #51bef9;", "-fx-background-color: #9656fa;", "-fx-background-color: #fa64fa;");
    private static int buttonColourIndex = 0;

    private final CommandExecutor commandExecutor;

    @FXML
    private TextField commandTextField;

    @FXML
    private Button enterBtn;

    public CommandBox(CommandExecutor commandExecutor) {
        super(FXML);
        this.commandExecutor = commandExecutor;
        // calls #setStyleToDefault() whenever there is a change to the text of the command box.
        commandTextField.textProperty().addListener((unused1, unused2, unused3) -> setStyleToDefault());
    }

    /**
     * Handles keyboard Enter button pressed event.
     */
    @FXML
    private void handleCommandEntered() {
        try {
            commandExecutor.execute(commandTextField.getText());
            commandTextField.setText("");
        } catch (CommandException | ParseException e) {
            setStyleToIndicateCommandFailure();
        }
    }

    /**
     * Handles on-screen Enter button pressed event.
     */
    @FXML
    private void handleCommandButtonPressed() {
        handleCommandEntered();
        String buttonColour = buttonColours.get(buttonColourIndex);
        enterBtn.setStyle(buttonColour);
        if (buttonColourIndex == 6) {
            buttonColourIndex = 0;
        } else {
            buttonColourIndex++;
        }
    }

    /**
     * Sets the command box style to use the default style.
     */
    private void setStyleToDefault() {
        commandTextField.getStyleClass().remove(ERROR_STYLE_CLASS);
    }

    /**
     * Sets the command box style to indicate a failed command.
     */
    private void setStyleToIndicateCommandFailure() {
        ObservableList<String> styleClass = commandTextField.getStyleClass();

        if (styleClass.contains(ERROR_STYLE_CLASS)) {
            return;
        }

        styleClass.add(ERROR_STYLE_CLASS);
    }

    /**
     * Represents a function that can execute commands.
     */
    @FunctionalInterface
    public interface CommandExecutor {
        /**
         * Executes the command and returns the result.
         *
         * @see Logic#execute(String)
         */
        CommandResult execute(String commandText) throws CommandException, ParseException;
    }

}
