package Model;

public class FileFormatting {

    private String Year;
    private String patientFirstName;
    private String patientLastName;
    private String birthDate;
    private String chartNo;
    private String userInputInfo;
    private String preInputInfo;
    private final String bar = "-";
    private final String missingBirthdate = "missingbirthdate";
    private final String missingChartNo = "missingchartno";

    // Constructor assigns all necessary variables.
    public FileFormatting(String Year, String lName, String fName, String birthDate, String ChartNo) {
        this.Year = Year;
        patientFirstName = fName;
        patientLastName = lName;
        this.birthDate = birthDate;
        this.chartNo = ChartNo;
    }

    public FileFormatting(String preInputInfo) {
        this.preInputInfo = preInputInfo;
    }

    /*
    Prior formatted Patient info will be entered into system here for renaming.
     */
    public String setTrucatedPreInput(int status, String preInputFile) {
        preInputInfo = preInputFile + bar;

        if (status == 1 || status == 2) {
            preInputInfo = preInputInfo + "x";
        } else {
            preInputInfo = preInputInfo + "p";
        }
        return preInputInfo;
    }

    // Sets name format if they are missing any information and fills it with preformatted inputs.
    public String setTruncatedName(int status) {
        if (status == 0 || status == 1) {
            if (birthDate.equals("")) {
                birthDate = missingBirthdate;
            }
            if (chartNo.equals("")) {
                chartNo = missingChartNo;
            }
        } else {
            if (chartNo.equals("")) {
                chartNo = missingChartNo;
            }
        }

        userInputInfo = Year + bar + patientLastName + "," + patientFirstName +
                bar + birthDate + bar + chartNo + bar;

        if (status == 0) {
            userInputInfo = userInputInfo + "p";
        } else if (status == 1) {
            userInputInfo = userInputInfo + "x";
        } else {
            userInputInfo = Year + bar + patientLastName + "," + patientFirstName +
                    bar + chartNo + bar + "x";
        }
        return userInputInfo;
    }



    // Formats patient folder to based on type values
    // 0  -  Records
    // 1  -  X-Rays
    // 2  -  Casts
    public String folderFormat(int type){
        String folderTitle;

        if(type == 2){
            folderTitle = Year + bar + patientLastName + "," + patientFirstName +
                    bar + chartNo;
        }else {
            folderTitle = Year + bar + patientLastName + "," + patientFirstName +
                    bar + birthDate + bar + chartNo;
        }


        return folderTitle;
    }


}
