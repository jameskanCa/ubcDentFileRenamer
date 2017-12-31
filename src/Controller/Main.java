package Controller;

import Model.Dialogues.StoringDialogue;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
Programmed by James Kan
*/
public class Main extends Application {
    private static Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {

        super.stop();
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

        new StoringDialogue();

    }

    public static Stage getPrimaryStage(){
        return primaryStage;
    }




}
