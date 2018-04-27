package Model;

import Controller.SaveLocationController;
import Model.Dialogues.PopUpDialogue;

import java.io.File;

public class StoringLocation {

    private static StoringLocation instance;
    private String path;
    private File folder;

    // Constructor following singleton pattern.
    private StoringLocation(String inputPath) {
        checkPath(inputPath);
        setPath(path);
        folder = new File(path);
        makeNewFolder();
    }

    // Singleton providing single access point for the overall program to access. This is to ensure no where else
    // in the program can the file location still be saved!
    public static StoringLocation StoringSingleton() {
        if (instance == null) {
            instance = new StoringLocation(SaveLocationController.getPath());
            return instance;
        } else {
            return instance;
        }
    }

    // Method creates a new folder during application. Mainly to replace the previously deleted folder when clearFolder
    // button is clicked and the replace folder method is called.
    public void makeNewFolder() {
        if (new File(path).exists()) {
            System.out.println("Folder Already Made");
        } else {
            try {
                new File(path).mkdirs();
                new PopUpDialogue("Folder created.");
            } catch (Exception e) {
                new PopUpDialogue("Error in creating folder, please manually create folder with format : \n" +
                        "Rename/");
            }
        }

    }

    public String getPath() {
        return path;
    }

    public File getFolder() {
        return folder;
    }

    private void setPath(String newPath) {
        path = newPath;
    }

    public void deletePreviousSaveInstance(){
        instance=null;
    }


    // Ensures that proper path file location is followed where '\' is at the end of the locations.
    public void checkPath(String pathName){
        if(!('\\' == (pathName.charAt(pathName.length() - 1)))){
            path = pathName + '\\';
        }else{
            path = pathName;
        }
    }


}
