package Model;

import Controller.SaveLocationController;
import Model.Dialogues.PopUpDialog;

import java.io.File;

public class StoringLocation {

    private static StoringLocation instance;
    private String path;
    private File folder;

    private StoringLocation(String inputPath) {
        setPath(inputPath);
        folder = new File(path);
        makeNewFolder();
    }

    public static StoringLocation StoringSingleton() {
        if (instance == null) {
            instance = new StoringLocation(SaveLocationController.getPath());
            return instance;
        } else {
            return instance;
        }
    }


    public void makeNewFolder() {

        if (new File(path).exists()) {
            System.out.println("Folder Already Made");
        } else {
            try {
                new File(path).mkdirs();
                new PopUpDialog("Folder created.");
            } catch (Exception e) {
                new PopUpDialog("Error in creating folder, please manually create folder with format : \n" +
                        "Rename");
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


}
