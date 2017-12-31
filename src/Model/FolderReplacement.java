package Model;

import Model.Dialogues.PopUpDialog;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class FolderReplacement {

    public FolderReplacement() {

        File[] listOfFiles = StoringLocation.StoringSingleton().getFolder().listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {

            if (listOfFiles[i].isFile()) {
                Path delete = FileSystems.getDefault().getPath
                        (StoringLocation.StoringSingleton().getPath() + listOfFiles[i].getName());
                try {
                    Files.delete(delete);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                new PopUpDialog("One or more files were unable to be deleted!");
            }
        }

        if (listOfFiles.length == 0) {
            System.out.println("Deletion Successful");
        } else {
            new PopUpDialog("The folder is NOT empty. Engage in attempt to create replacement folder.");
            folderReplacement();
        }
    }

    /*
    Forcibly removing folder to ensure no files are left behind.
     */
    private void folderReplacement() {
        try {
            Files.delete(FileSystems.getDefault().getPath(StoringLocation.StoringSingleton().getPath()));
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", "");
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n");
        } catch (IOException x) {
            System.err.println(x);
        }
        StoringLocation.StoringSingleton().makeNewFolder();
    }
}
