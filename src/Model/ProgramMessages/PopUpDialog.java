package Model.ProgramMessages;

import Controller.Main;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopUpDialog {

    public PopUpDialog( String message){
        try {
            final Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.initOwner(Main.getPrimaryStage());
            VBox dialogVbox = new VBox(50);
            dialogVbox.getChildren().addAll(new Text(message));
            Scene dialogScene = new Scene(dialogVbox,300, 300);
            dialogStage.setScene(dialogScene);
            dialogStage.show();

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
