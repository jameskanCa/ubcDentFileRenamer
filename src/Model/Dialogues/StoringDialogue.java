package Model.Dialogues;

import Controller.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StoringDialogue {

    public static Stage dialogStage;

    public StoringDialogue() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/SetSavingLocationDialogue.fxml"));
        dialogStage = new Stage();
        dialogStage.setTitle("Enter Save Pathway");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.initOwner(Main.getPrimaryStage());
        Scene dialogScene = new Scene(root);
        dialogStage.setScene(dialogScene);
        dialogStage.show();

    }

    public static void closeStoringDialogue(){
        dialogStage.close();
    }
}
