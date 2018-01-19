package Model;

public class FileRenamingPreInput extends FileRenaming{
    private FileFormatting fileFormatting;

    private String patientInfo;
    private int condition;

    // Method is the central point of task distribution for fully and previously formatted file names.
    public FileRenamingPreInput(String preInputInfo, int status) {
        fileFormatting = new FileFormatting(preInputInfo);
        this.condition = status;
        this.patientInfo = fileFormatting.setTrucatedPreInput(condition, preInputInfo);
        peformSeriesRename(patientInfo,status);
    }
}
