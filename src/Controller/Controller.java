package Controller;

import Model.FileRenamingFullInput;
import Model.FileRenamingPreInput;
import Model.FolderReplacement;
import Model.Dialogues.AboutDialogue;
import Model.Dialogues.PopUpDialog;
import Model.Dialogues.StoringDialogue;
import Model.StoringLocation;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class Controller {
    @FXML
    private TextField yearParameter;
    @FXML
    private TextField firstNamePram;
    @FXML
    private TextField lastNamePram;
    @FXML
    private TextField birthdayPram;
    @FXML
    private TextField chartNoPram;
    @FXML
    private TextField preInputField;
    @FXML
    private RadioButton XRay;
    @FXML
    private RadioButton Casts;
    @FXML
    private RadioButton Files;
    @FXML
    final ToggleGroup group = new ToggleGroup();
    @FXML
    private Button clearFolder;
    @FXML
    private Button renameButtonFullInput;
    @FXML
    private Button renameButtonPreInput;
    @FXML
    private MenuItem fileEditItem;
    @FXML
    private MenuItem aboutItem;


    private String PreInputField;
    private String Year;
    private String patientFirstName;
    private String patientLastName;
    private String birthdate;
    private String ChartNo;
    private FileRenamingFullInput rename;
    private FileRenamingPreInput renamePreInput;
    private int styleSelection = 0;

    /*
    Method to open up dialogue to edit new save location.
     */
    @FXML
    void setFileEdit() {
        try {
            StoringLocation.StoringSingleton().deletePreviousSaveInstance();
            new StoringDialogue();
        } catch (Exception e) {
            e.printStackTrace();
            new PopUpDialog("Error with opening new save location dialogue. Please restart the program.");
        }
    }

    @FXML
    void openAboutItem() {
        new AboutDialogue();
    }

    @FXML
    void setYear() {
        Year = "";
        Year = yearParameter.getText();
    }

    @FXML
    void setFirstName() {
        patientFirstName = "";
        patientFirstName = this.firstNamePram.getText();
    }

    @FXML
    void setLastName() {
        patientLastName = "";
        patientLastName = lastNamePram.getText();
    }

    @FXML
    void setBirthday() {
        birthdate = "";
        birthdate = birthdayPram.getText();
    }

    @FXML
    void setChartNo() {
        ChartNo = "";
        ChartNo = chartNoPram.getText();
    }


    @FXML
    void setPreInputField() {
        PreInputField = "";
        PreInputField = preInputField.getText();
    }

    /*
    Method will clear all but year textfields. Year
    will be maintained due to repetitiveness.
     */
    public void clearFolderPressed() {
        firstNamePram.clear();
        lastNamePram.clear();
        birthdayPram.clear();
        chartNoPram.clear();
        preInputField.clear();
        new FolderReplacement();
    }

    /*
    Method will rename all files placed within the folder based on
     */
    public void renameButtonPressed() {
        setYear();
        setFirstName();
        setLastName();
        setBirthday();
        setChartNo();
        obtainRadioGroup();

       if (styleSelection == 0 || styleSelection == 1) {
            if (!Year.isEmpty() && !patientFirstName.isEmpty() && !patientLastName.isEmpty()) {
                rename = new FileRenamingFullInput(Year, patientLastName, patientFirstName, birthdate, ChartNo, styleSelection);
            } else {
                new PopUpDialog("Inputs required are Missing!");
            }
        } else {
            if (!Year.isEmpty() && !patientFirstName.isEmpty() && !patientLastName.isEmpty() && birthdate.isEmpty() &&
                    !ChartNo.isEmpty()) {
                rename = new FileRenamingFullInput(Year, patientLastName, patientFirstName, birthdate, ChartNo, styleSelection);
            } else {
                new PopUpDialog("Birth date may not be empty or missing info.");
            }
        }
    }

    public void preInputButtonPressed() {
        setPreInputField();
        obtainRadioGroup();

        if (!PreInputField.isEmpty()) {
            renamePreInput = new FileRenamingPreInput(PreInputField, styleSelection);
        } else {
            new PopUpDialog("Pre-input slot is empty");
        }
    }


    /*
    Radio group, 0 is Record files
                 1 is XRay image tags
                 2 is Cast groups
    Upon selection, style number will be selected. Default is 0.
     */
    public int obtainRadioGroup() {
        Casts.setToggleGroup(group);
        XRay.setToggleGroup(group);
        Files.setToggleGroup(group);

        if (Files.isSelected()) {
            styleSelection = 0;
        } else if (XRay.isSelected()) {
            styleSelection = 1;
        } else if (Casts.isSelected()) {
            styleSelection = 2;
        }
        return styleSelection;
    }


}
