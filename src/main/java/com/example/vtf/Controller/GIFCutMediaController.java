package com.example.vtf.Controller;

import com.example.vtf.Engine.PageJump;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GIFCutMediaController implements Initializable {
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
        if(endSliderVal < startSliderVal) {
            System.out.println("OH, can't cut if end duration is smaller than start");

            return;
        }
        System.out.println("Can cut");



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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GIFCutMedia_slider_startSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> location, Number arg1, Number arg2){
                startSliderVal = GIFCutMedia_slider_startSlider.getValue();
                endSliderVal = GIFCutMedia_slider_endSlider.getValue();

            }

        }



        );
    }
}

