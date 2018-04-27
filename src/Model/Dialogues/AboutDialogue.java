package Model.Dialogues;

import Controller.Main;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AboutDialogue {

    final String message= "Programmed by James Kan \n" +
            "Version 1.3 \n" +
            "Updated: 2018/4/26 \n" +
            "For inquiries or bugs please email: james0077721@hotmail.com";

    // Constructor to open dialogue that displays the about page when drop down about is clicked.
    public AboutDialogue() {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setTitle("About");
        dialogStage.getIcons().add(new Image("Images/icon.png"));
        dialogStage.initOwner(Main.getPrimaryStage());
        VBox dialogVbox = new VBox(50);
        dialogVbox.getChildren().addAll(new Text(message));
        Scene dialogScene = new Scene(dialogVbox);
        dialogStage.setScene(dialogScene);
        dialogStage.show();

    }
}
