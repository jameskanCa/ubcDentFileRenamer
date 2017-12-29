package Model;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class FileRenaming {
    private StoringLocation storingLocation;
    private FileFormatting fileFormatting;

    private String TruncatedFileName;
    private String PreInputName;
    private boolean condition;

    public FileRenaming(String Year, String lName, String fName, String birthDate, String ChartNo, Boolean status) {
        storingLocation = new StoringLocation();
        fileFormatting = new FileFormatting(Year, lName, fName, birthDate, ChartNo);
        this.condition = status;

        this.TruncatedFileName = fileFormatting.setTruncatedName(condition);
        peformSeriesRename(this.TruncatedFileName);
    }


    public FileRenaming(String PreinputFile) {
        storingLocation = new StoringLocation();
        this.PreInputName = PreinputFile;
        fileFormatting.setTrucatedPreInput(condition, this.PreInputName);
        peformSeriesRename(TruncatedFileName);
    }

    public void peformSeriesRename(String name) {

        try {
            File[] listOfFiles = storingLocation.getFolder().listFiles();

            for (int i = 0; i < listOfFiles.length; i++) {

                if (listOfFiles[i].isFile()) {
                    String fileNum = Integer.toString(i + 1);

                    Path movefrom = FileSystems.getDefault().getPath(storingLocation.getPath() + listOfFiles[i].getName());
                    Path target = FileSystems.getDefault().getPath(storingLocation.getPath() + name + fileNum + ".jpg");
                    System.out.println("Item Renamed" + (i + 1));

                    try {
                        Files.move(movefrom, target, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    System.out.println("Error ");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to obtain previous files");
        }


    }

    public boolean clearAndReplaceFolder() {
        boolean success = false;

        File[] listOfFiles = storingLocation.getFolder().listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {

            if (listOfFiles[i].isFile()) {

                Path delete = FileSystems.getDefault().getPath(storingLocation.getPath() + listOfFiles[i].getName());

                try {
                    Files.delete(delete);
                    success = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Deletion error");
            }
        }

        try {
            Files.delete(FileSystems.getDefault().getPath(storingLocation.getPath()));

        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", "");
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n");
        } catch (IOException x) {
            System.err.println(x);
        }

        storingLocation.makeNewFolder();

        return success;
    }
}