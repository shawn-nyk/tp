package seedu.address.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

import java.awt.*;

public class ExitDialog extends UiPart<DialogPane> {

    private static final String FXML = "ExitDialog.fxml";

    @FXML
    private DialogPane dialogPane;

    @FXML
    private Button yesButton;

    @FXML
    private Button noButton;

    private Dialog<Boolean> dialog;
    private WindowEvent event;

    public ExitDialog(WindowEvent event) {
        super(FXML);
        dialog = new Dialog<>();
        dialog.setDialogPane(dialogPane);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        dialog.setWidth(220.0);
        dialog.setHeight(144.0);
        dialog.setX((screenSize.width - dialog.getWidth()) / 2);
        dialog.setY((screenSize.height - dialog.getHeight()) / 2);

        Window window = dialog.getDialogPane().getScene().getWindow();
        window.setOnCloseRequest((e) -> {
            dialog.hide();
            event.consume();
        });

        this.event = event;
    }

    public void show() {
        dialog.showAndWait();
    }

    @FXML
    private boolean confirmExit() {
        dialog.setResult(Boolean.TRUE);
        dialog.hide();
        return true;
    }

    @FXML
    private boolean cancelExit() {
        dialog.setResult(Boolean.TRUE);
        event.consume();
        dialog.hide();
        return false;
    }
}
