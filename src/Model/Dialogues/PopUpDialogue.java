package Model.Dialogues;

import Controller.Main;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopUpDialogue {

    /*
    PopUp dialogue built to present system info to user
     */
    public PopUpDialogue(String message) {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setTitle("Message");
        dialogStage.getIcons().add(new Image("Images/icon.png"));
        dialogStage.initOwner(Main.getPrimaryStage());
        VBox dialogVbox = new VBox(50);
        dialogVbox.getChildren().addAll(new Text(message));
        Scene dialogScene = new Scene(dialogVbox);
        dialogStage.setScene(dialogScene);
        dialogStage.show();

    }
}
