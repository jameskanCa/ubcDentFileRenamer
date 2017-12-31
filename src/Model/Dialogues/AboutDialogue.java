package Model.Dialogues;

import Controller.Main;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AboutDialogue {

    final String message= "Programmed by James Kan \n" +
            "Version 1 \n" +
            "Updated: 2017/12/30";


    public AboutDialogue() {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setTitle("About");
        dialogStage.initOwner(Main.getPrimaryStage());
        VBox dialogVbox = new VBox(50);
        dialogVbox.getChildren().addAll(new Text(message));
        Scene dialogScene = new Scene(dialogVbox);
        dialogStage.setScene(dialogScene);
        dialogStage.show();

    }
}
