package Controller;

import Model.ProgramMessages.PopUpDialog;
import Model.StoringLocation;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
Programmed by James Kan
*/
public class Main extends Application {
    StoringLocation storingLocation;
    private static Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    // Method override allows for behaviour prior to GUI execution.
    @Override
    public void init() throws Exception {
        storingLocation = new StoringLocation();
        storingLocation.makeNewFolder();
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        Parent  root = FXMLLoader.load(getClass().getResource("../View/ProgramGUI.fxml"));
        primaryStage.setTitle("UBC Dentistry File Renaming Program");
        primaryStage.setScene(new Scene(root, 562, 500));
        primaryStage.setMaxHeight(535);
        primaryStage.setMaxWidth(562);
        primaryStage.setMinHeight(535);
        primaryStage.setMinWidth(562);
        primaryStage.show();
    }

    public static Stage getPrimaryStage(){
        return primaryStage;
    }
}
