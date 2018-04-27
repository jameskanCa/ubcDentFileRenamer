package Model;

import Model.Dialogues.PopUpDialogue;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileRenaming {

    // Method renames all files within folder. Obtains number of files in folder, and renames each file to the
    // patient format expected at UBC Dentistry. Utilizes the condition to determine file type and name for the
    // renaming information.
    public void peformSeriesRename(String name, int condition) {

        try {
            File[] listOfFiles = StoringLocation.StoringSingleton().getFolder().listFiles();

            if(listOfFiles.length <= 0){
                new PopUpDialogue("Heads up, your folder is empty!");
            }

            for (int i = 0; i < listOfFiles.length; i++) {

                if (listOfFiles[i].isFile()) {

                    String fileNum = Integer.toString(i + 1);
                    Path movefrom = FileSystems.getDefault().getPath(StoringLocation.StoringSingleton().getPath() + listOfFiles[i].getName());

                    Path target;
                    if(condition == 0){
                         target = FileSystems.getDefault().getPath(StoringLocation.StoringSingleton().getPath() + name + fileNum + ".pdf");
                    }else{
                         target = FileSystems.getDefault().getPath(StoringLocation.StoringSingleton().getPath() + name + fileNum + ".jpg");
                    }

                    try {
                        Files.move(movefrom, target, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    new PopUpDialogue("Renaming has encountered issue");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            new PopUpDialogue("Unable to obtain previous files");
        }


    }

    // Takes Pre-Formatted style and creates folder for each patient dependent on the type of file.
    public void formPatientFolder(String folderFormat) {
            try {
                new File(StoringLocation.StoringSingleton().getPath() + folderFormat).mkdirs();
            } catch (Exception e) {
                new PopUpDialogue("Error in creating folder, please manually create folder with format : \n" +
                        "Rename");
            }
        }

    }
