package Model;

public class FileRenamingPreInput extends FileRenaming{
    private FileFormatting fileFormatting;

    private String patientInfo;
    private int condition;

    public FileRenamingPreInput(String preInputInfo, int status) {
        fileFormatting = new FileFormatting(preInputInfo);
        this.condition = status;
        this.patientInfo = fileFormatting.setTrucatedPreInput(condition, preInputInfo);
        peformSeriesRename(patientInfo);
    }
}
