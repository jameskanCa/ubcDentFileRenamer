package Controller;

import Model.Dialogues.StoringDialogue;
import Model.StoringLocation;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SaveLocationController {

    private static String path;

    @FXML
    private Button useNewLocation;
    @FXML
    private TextField pathText;

    @FXML
    void setSaveLocation(){
        path = "";
        path = pathText.getText();
    }

    public static String getPath(){
        return path;
    }

    @FXML
    void saveButton(){
        setSaveLocation();
        StoringLocation.StoringSingleton();
        StoringDialogue.closeStoringDialogue();
    }
}
