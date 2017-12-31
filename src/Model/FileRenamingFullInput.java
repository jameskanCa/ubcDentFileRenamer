package Model;

public class FileRenamingFullInput extends FileRenaming{
    private FileFormatting fileFormatting;

    private String folderInfo;
    private String patientInfo;
    private int condition;

    public FileRenamingFullInput(String Year, String lName, String fName, String birthDate, String ChartNo, int status) {

        fileFormatting = new FileFormatting(Year, lName, fName, birthDate, ChartNo);
        folderInfo = fileFormatting.folderFormat();
        this.condition = status;
        this.patientInfo = fileFormatting.setTruncatedName(condition);
        peformSeriesRename(patientInfo);
        formPatientFolder(folderInfo);
    }





}