package Model;

import java.io.File;

public class StoringLocation {

    private String path;
    private File folder;

    public StoringLocation() {
        path = "C:/Users/user/Desktop/TESTS/";
        // why is it that i will get a null here
        // if I put the folder stuff in the make new Folder?
        folder = new File(path);
        // Temporarily holding info on "M:/X-RAY RENAMING/"
    }

    public StoringLocation(String specifiedLocation) {
        path = specifiedLocation;
    }

    // Effects: Creates new folder. If duplicates happen it doesn't create new folder
    public void makeNewFolder() {

        if (new File(path).exists()) {
            System.out.println("Folder Already Made");
        } else {
            try {
                new File(path).mkdirs();
            } catch (Exception e) {
                System.out.println("Error in creating folder");
            }
        }

    }

    public String getPath() {
        return path;
    }

    public File getFolder() {
        return folder;
    }
}
