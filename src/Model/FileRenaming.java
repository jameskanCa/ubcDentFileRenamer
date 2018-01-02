package Model;

import Model.Dialogues.PopUpDialog;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileRenaming {

    public void peformSeriesRename(String name, int condition) {
        try {
            File[] listOfFiles = StoringLocation.StoringSingleton().getFolder().listFiles();

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
                    new PopUpDialog("Renaming has encountered issue");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            new PopUpDialog("Unable to obtain previous files");
        }


    }

    public void formPatientFolder(String folderFormat) {

            try {
                new File(StoringLocation.StoringSingleton().getPath() + folderFormat).mkdirs();
                new PopUpDialog("Folder created.");
            } catch (Exception e) {
                new PopUpDialog("Error in creating folder, please manually create folder with format : \n" +
                        "Rename");
            }
        }

    }
