package com.example.vtf.Controller;

import com.example.vtf.Engine.PageJump;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class GIFCutMediaController {
    //get the cut start range and end range from this UI
    // then using ffmpeg to cut, and export it into GIF file.

    @FXML
    private Button GIFCutMedia_button_back;

    @FXML
    private Button GIFCutMedia_button_toGIF;

    @FXML
    private Slider GIFCutMedia_slider_endSlider;

    @FXML
    private Slider GIFCutMedia_slider_startSlider;

    double endSliderVal = 0;
    double startSliderVal = 0;

    @FXML
    void GIFCutMedia_back(ActionEvent event) throws IOException {
        PageJump.getMainPage();
    }

    @FXML
    void GIFCutMedia_toGIF(ActionEvent event) {
        if(endSliderVal < startSliderVal) return;

    }

    @FXML
    void endDurationChoose(DragEvent event) {
        endSliderVal = GIFCutMedia_slider_endSlider.getValue();
    }

    @FXML
    void endSlider(MouseEvent event) {

    }

    @FXML
    void startDurationChoose(DragEvent event) {
        startSliderVal = GIFCutMedia_slider_startSlider.getValue();
    }

    @FXML
    void startSlide(MouseEvent event) {

    }

}

