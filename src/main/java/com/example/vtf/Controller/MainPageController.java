package com.example.vtf.Controller;

import com.example.vtf.Engine.MediaProcessor;
import com.example.vtf.Engine.PageJump;
import com.example.vtf.Ultilities.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.example.vtf.Ultilities.PAGE_INDEX.MEDIA_GIF_CUT;
import static com.example.vtf.Ultilities.PAGE_INDEX.MEDIA_VIEW;

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
    @FXML
    private TextField MainPage_TextField_OutputName;

    private Stage currentStage;
    private File uploadedFile;
    private MediaProcessor mediaProcessor;

    private static MainPageController instance;
    private ViewController viewController;

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
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Media File (*.mp4)",
                                                                                                "*.mp4");
        fileChooser.getExtensionFilters().add(extensionFilter);
        uploadedFile = fileChooser.showOpenDialog(currentStage);

        if(uploadedFile != null){

            String fileName = uploadedFile.getName();
            String fileSize = Utils.getFileSize(uploadedFile);
            String fileExt = Utils.getFileExtension(fileName);

            this.MainPage_TextField_FileName.setText(fileName);
            this.MainPage_TextField_FileSize.setText(fileSize);
            this.MainPage_TextField_Ext.setText(fileExt);

            MediaProcessor.getInstance().setMedia(new Media(uploadedFile.toURI().toString()));
            MediaProcessor.getInstance().setFilePath(uploadedFile.getPath());
            MediaProcessor.getInstance().setFileName(fileName);


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
        MediaProcessor.getInstance().setMedia(new Media(uploadedFile.toURI().toString()));
        PageJump.switchPage(event, MEDIA_VIEW);
        ViewController.getInstance().getView_MediaView_mediaoutput().setMediaPlayer(new MediaPlayer(MediaProcessor.getInstance().getMedia()));
        //ViewController.getInstance().getView_MediaView_mediaoutput().getMediaPlayer().play();
    }
    @FXML
    void MainPage_toGIF(ActionEvent event) throws IOException {
        if(uploadedFile == null){
            System.out.println("You haven't uploaded any file");

        }else if(uploadedFile.getName().equals(MainPage_TextField_OutputName.getText())){
            System.out.println("Name cannot be duplicated");

        }else if(MainPage_TextField_OutputName.getText().isBlank() || MainPage_TextField_OutputName.getText().isEmpty()){
            System.out.println("Name cannot be blank or empty");

        }else{
            MediaProcessor.getInstance().setOutputPath("src/main/resources/output/" + Utils.swapExtensionIntoGIF(MainPage_TextField_OutputName.getText()));
            MediaProcessor.getInstance().setMedia(new Media(uploadedFile.toURI().toString()));
            PageJump.switchPage(event, MEDIA_GIF_CUT);
        }
    }
}


