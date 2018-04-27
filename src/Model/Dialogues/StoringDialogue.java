package Model.Dialogues;

import Controller.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StoringDialogue {

    public static Stage dialogueStage;
    private static Main m;

    // Opens interface to edit save location.
    public StoringDialogue(Main m) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/SetSavingLocationDialogue.fxml"));
        dialogueStage = new Stage();
        this.m = m;
        dialogueStage.initStyle(StageStyle.UNDECORATED);
        dialogueStage.setTitle("Enter Save Pathway");
        dialogueStage.initModality(Modality.APPLICATION_MODAL);
        dialogueStage.initOwner(Main.getPrimaryStage());
        Scene dialogScene = new Scene(root);
        dialogueStage.setScene(dialogScene);
        dialogueStage.show();


    }

    // Second constructor to handle empty argument.
    public StoringDialogue() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/SetSavingLocationDialogue.fxml"));
        dialogueStage = new Stage();
        this.m = m;
        dialogueStage.initStyle(StageStyle.UNDECORATED);
        dialogueStage.setTitle("Enter Save Pathway");
        dialogueStage.getIcons().add(new Image("Images/icon.png"));
        dialogueStage.initModality(Modality.APPLICATION_MODAL);
        dialogueStage.initOwner(Main.getPrimaryStage());
        Scene dialogScene = new Scene(root);
        dialogueStage.setScene(dialogScene);
        dialogueStage.show();


    }

    //Close dialogue by closing screen down and setting visibility of main program to true.
    public static void closeStoringDialogue(){
        dialogueStage.close();
        m.setVisible();
    }
}
