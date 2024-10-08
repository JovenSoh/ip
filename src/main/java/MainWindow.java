import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import zero.Zero;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;

    private Zero zero;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaPengi.jpeg"));
    private Image zeroImage = new Image(this.getClass().getResourceAsStream("/images/DaChad.png"));

    /** Injects the Zero instance */
    public void setZero(Zero z) {
        zero = z;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Zero's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = zero.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getZeroDialog(response, zeroImage)
        );
        userInput.clear();
    }
}
