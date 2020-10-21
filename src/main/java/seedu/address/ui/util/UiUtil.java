package seedu.address.ui.util;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public abstract class UiUtil {

    /**
     * Prevent initialization of class.
     */
    private UiUtil() {}

    /**
     * Closes the help window when the escape button is pressed and released.
     *
     * @param stage Current stage.
     */
    public static void addCloseWindowOnEsc(Stage stage) {
        stage.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
            if (KeyCode.ESCAPE == event.getCode()) {
                stage.close();
            }
        });
    }

}
