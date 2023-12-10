package com.example.vtf.Controller;
import com.example.vtf.Engine.MediaProcessor;
import com.example.vtf.Engine.PageJump;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaView;

import java.io.IOException;

public class ViewController {
    @FXML
    private MediaView View_MediaView_mediaoutput;

    @FXML
    private AnchorPane View_anchorPane_pane;

    @FXML
    private Button View_button_Back;

    @FXML
    private Button View_button_toGIF;

    private MediaProcessor mediaProcessor;

    private static ViewController instance;

    private ViewController(){}

    public static ViewController getInstance(){
        if(instance == null){
            instance = new ViewController();
        }
        return instance;
    }
    public MediaView getView_MediaView_mediaoutput(){
        return this.View_MediaView_mediaoutput;
    }
    public void playMedia(){

    }

    @FXML
    void View_Back(ActionEvent event) throws IOException {
        PageJump.switchPage(event, "MainPage");
    }

    @FXML
    void View_MediaView(ActionEvent event) {

    }

    @FXML
    void View_ToGIF(ActionEvent event) {

    }
}
