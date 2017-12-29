package Model;

public class FileFormatting {

    private String Year;
    private String patientFirstName;
    private String patientLastName;
    private String birthDate;
    private String ChartNo;
    private String TruncatedFileName;
    private final String bar = "-";

    public FileFormatting(String Year, String lName, String fName, String birthDate, String ChartNo) {
        this.Year = Year;
        patientFirstName = fName;
        patientLastName = lName;
        this.birthDate = birthDate;
        this.ChartNo = ChartNo;
    }

    public void setTrucatedPreInput(boolean status, String preInputFile) {
        TruncatedFileName = preInputFile + bar;

        if (status) {
            TruncatedFileName = TruncatedFileName + "p";
        } else {
            TruncatedFileName = TruncatedFileName + "x";
        }

    }

    public String setTruncatedName(boolean status) {
        TruncatedFileName = Year + bar + patientLastName + "," + patientFirstName +
                bar + birthDate + bar + ChartNo + bar;
        if (status) {
            TruncatedFileName = TruncatedFileName + "p";
        } else {
            TruncatedFileName = TruncatedFileName + "x";
        }

        return TruncatedFileName;
    }

}
