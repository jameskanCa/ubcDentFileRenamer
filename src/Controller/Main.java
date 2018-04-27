package Controller;

import Model.Dialogues.StoringDialogue;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/*
Programmed by James Kan
Last Update: 04/26/2018
Program Description:
At UBC Dentistry, patient records over the past 40 years are to be digitized into digital records,
as mandated by the Canadian government. To speed up the process of manual labour, the task of naming hundreds of scanned
files and pictures can be renamed using this program. The program was implemented in Jan 3rd and has been in use by
employees for the purpose of digitizing the files within the safe and secure networks of UBC Dentistry servers.
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
        Parent  root = FXMLLoader.load(getClass().getResource("/View/ProgramGUI.fxml"));
        primaryStage.getIcons().add(new Image("Images/icon.png"));
        primaryStage.setTitle("UBC Dentistry File Renaming Program");
        primaryStage.setScene(new Scene(root, 562, 500));
        primaryStage.setMaxHeight(535);
        primaryStage.setMaxWidth(562);
        primaryStage.setMinHeight(535);
        primaryStage.setMinWidth(562);


        new StoringDialogue(this);



    }

    // Allows for the demonstration of one screen in use at a time.
    public static void setVisible(){
        primaryStage.show();
    }

    public static Stage getPrimaryStage(){
        return primaryStage;
    }
}
