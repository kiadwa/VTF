package com.example.vtf.Controller;

import com.example.vtf.Engine.MediaProcessor;
import com.example.vtf.Engine.PageJump;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

import static com.example.vtf.UI.PAGE_INDEX.MEDIA_VIEW;

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
    @FXML
    private Button MainPage_button_toGIF;
    @FXML
    private Button MainPage_button_view;
    private Stage currentStage;
    private File uploadedFile;
    private MediaProcessor mediaProcessor;

    private static MainPageController instance;

    private MainPageController(){}

    public static MainPageController getInstance(){
        if(instance == null){
            instance = new MainPageController();
        }
        return instance;
    }

    @FXML
    void MainPage_onAction_upload(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        //FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Media File (*.mp4)", "*.txt");
        //fileChooser.getExtensionFilters().add(extensionFilter);
        uploadedFile = fileChooser.showOpenDialog(currentStage);
        if(uploadedFile != null){
            String fileName =  uploadedFile.getName();
            long fileSize = uploadedFile.getTotalSpace();

            this.MainPage_TextField_FileName.setText(fileName);
            //this.MainPage_TextField_FileSize.setText();
        }else{
            System.out.println("There is no file");
        }
    }
    @FXML
    void MainPage_View(ActionEvent event) throws IOException {
        if(uploadedFile == null) {
            System.out.println("You haven't uploaded any file");
            return;
        }
        PageJump.switchPage(event, MEDIA_VIEW);

    }
    @FXML
    void MainPage_toGIF(ActionEvent event) {

    }

}


