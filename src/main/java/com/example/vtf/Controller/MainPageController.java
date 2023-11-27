package com.example.vtf.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MainPageController{
    @FXML
    private AnchorPane MainPage_AnchorPane_pane;

    @FXML
    private TextField MainPage_TextField_Duration;

    @FXML
    private TextField MainPage_TextField_Ext;

    @FXML
    private TextField MainPage_TextField_FileName;

    @FXML
    private TextField MainPage_TextField_FileSize;

    @FXML
    private Button MainPage_button_uploadButton;

    private Stage currentStage;
    private File uploadedFile;
    @FXML
    void MainPage_onAction_upload(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Media File (*.mp4)", "*.txt");
        fileChooser.getExtensionFilters().add(extensionFilter);
        uploadedFile = fileChooser.showOpenDialog(currentStage);

        if(uploadedFile != null){

        }else{

        }



    }

}


