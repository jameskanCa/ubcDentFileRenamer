package Model.Dialogues;

import Controller.Main;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopUpDialog {

    /*
    PopUp dialogue built to present system info to user
     */
    public PopUpDialog(String message) {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setTitle("Message");
        dialogStage.initOwner(Main.getPrimaryStage());
        VBox dialogVbox = new VBox(50);
        dialogVbox.getChildren().addAll(new Text(message));
        Scene dialogScene = new Scene(dialogVbox);
        dialogStage.setScene(dialogScene);
        dialogStage.show();

    }
}
