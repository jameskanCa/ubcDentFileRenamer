package Controller;

import Model.FileRenaming;
import Model.ProgramMessages.PopUpDialog;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


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
    private Label errorMessage;

    final ToggleGroup group = new ToggleGroup();


    @FXML
    private Button clearFolder;

    @FXML
    private Button renameButton;

    private String PreInputField;
    private String Year;
    private String patientFirstName;
    private String patientLastName;
    private String Birthdate;
    private String ChartNo;
    private FileRenaming rename;
    private boolean styleSelection;


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
        Birthdate = "";
        Birthdate = birthdayPram.getText();
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

    public void clearFolderPressed() {
        yearParameter.clear();
        firstNamePram.clear();
        lastNamePram.clear();
        birthdayPram.clear();
        chartNoPram.clear();
        preInputField.clear();

        rename.clearAndReplaceFolder();
    }

    public void renameButtonPressed() {
        setYear();
        setFirstName();
        setLastName();
        setBirthday();
        setChartNo();
        setPreInputField();
        obtainRadioGroup();

        if ((!Year.isEmpty() && !patientFirstName.isEmpty() && !patientLastName.isEmpty() && !Birthdate.isEmpty() &&
                !ChartNo.isEmpty())) {

            rename = new FileRenaming(Year, patientLastName, patientFirstName, Birthdate, ChartNo, styleSelection);

        } else if (!PreInputField.isEmpty()) {
            rename = new FileRenaming(PreInputField);
        } else {
            PopUpDialog p = new PopUpDialog("Unable to rename");
        }
    }

    public boolean obtainRadioGroup() {
        styleSelection = false;
        Casts.setToggleGroup(group);
        XRay.setToggleGroup(group);
        Files.setToggleGroup(group);

        if (Files.isSelected()) {
            styleSelection = true;
        } else {
            styleSelection = false;
        }
        return styleSelection;
    }


}
