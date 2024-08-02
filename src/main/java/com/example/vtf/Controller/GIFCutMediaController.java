package com.example.vtf.Controller;

import com.example.vtf.Engine.MediaProcessor;
import com.example.vtf.Engine.Message;
import com.example.vtf.Engine.PageJump;
import com.example.vtf.Engine.Message.Status;
import com.example.vtf.FFmpegStream.FFmpegWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class GIFCutMediaController implements Initializable, Notificator {
    //get the cut start range and end range from this UI
    // then using ffmpeg to cut, and export it into GIF file.

    @FXML
    private Button GIFCutMedia_button_back;
    @FXML
    private Button GIFCutMedia_button_View;

    @FXML
    private Button GIFCutMedia_button_toGIF;

    @FXML
    private Slider GIFCutMedia_slider_endSlider;

    @FXML
    private Slider GIFCutMedia_slider_startSlider;

    double endSliderVal = 0;
    double startSliderVal = 0;
    int startDu = 0;
    int endDu = 0;
    FFmpegWrapper fFmpegWrapper = new FFmpegWrapper();
    MediaProcessor mediaProcessor = MediaProcessor.getInstance();
    @FXML
    private MediaView GIFCutMedia_mediaView_preview;

    @FXML
    void GIFCutMedia_back(ActionEvent event) throws IOException {
        PageJump.switchPage(event,"MainPage");
    }

    @FXML
    void GIFCutMedia_View(ActionEvent event) {
        if(GIFCutMedia_mediaView_preview.getMediaPlayer() == null) {

            MediaPlayer md = MediaProcessor.getInstance().getMediaPlayer();
            GIFCutMedia_mediaView_preview.setMediaPlayer(md);
        }
        if(startDu > endDu){
            showNotification(new Message("End time cannot be before start time", Status.FAIL));
            return;
        }
        else if(GIFCutMedia_mediaView_preview.getMediaPlayer().getStatus() != MediaPlayer.Status.PLAYING) {

            GIFCutMedia_mediaView_preview.getMediaPlayer().setStartTime(Duration.seconds(startDu));
            GIFCutMedia_mediaView_preview.getMediaPlayer().setStopTime(Duration.seconds(endDu));
            System.out.println(startDu);
            System.out.println(endDu);
            GIFCutMedia_mediaView_preview.getMediaPlayer().play();

        }else if(GIFCutMedia_mediaView_preview.getMediaPlayer().getStatus() == MediaPlayer.Status.PLAYING){
            GIFCutMedia_mediaView_preview.getMediaPlayer().stop();
        }
    }

    @FXML
    void GIFCutMedia_toGIF(ActionEvent event) {
        disableSlider();
        if (mediaProcessor.getMedia() != null && endSliderVal > startSliderVal) {
            MediaPlayer mediaPlayer = mediaProcessor.getMediaPlayer();
            mediaPlayer.setOnReady(() -> {
                // This block is executed when the media is ready
                Duration duration = mediaPlayer.getMedia().getDuration();

                double durationInSeconds = duration.toSeconds();

                double start_second =  durationInSeconds * startSliderVal * 0.01;
                double end_second =  durationInSeconds * endSliderVal * 0.01;

                String ss = String.valueOf(start_second);
                String du = String.valueOf(end_second - start_second);
                //test print

                //cut file here
                FFmpegWrapper.cutMedia(MediaProcessor.getInstance().getFilePath(),
                                        ss,
                                        du,
                                        MediaProcessor.getInstance().getOutputPath());
            });
        }

        if (endSliderVal < startSliderVal) {
            showNotification(new Message("End time cannot be before start time", Status.FAIL));
            enableSlider();
            return;
        }
        enableSlider();
    }


    void disableSlider(){
        GIFCutMedia_slider_startSlider.setDisable(true);
        GIFCutMedia_slider_endSlider.setDisable(true);
    }
    void enableSlider(){
        GIFCutMedia_slider_endSlider.setDisable(false);
        GIFCutMedia_slider_startSlider.setDisable(false);
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
        GIFCutMedia_slider_endSlider.valueProperty().addListener(new ChangeListener<Number>() {
            //initiate a listener to keep track of change on the end slider
            @Override
            public void changed(ObservableValue<? extends Number> location, Number arg1, Number arg2){
                endSliderVal = GIFCutMedia_slider_endSlider.getValue();
                endDu = (int) (mediaProcessor.getMedia().getDuration().toSeconds() * endSliderVal * 0.01);
            }
        });
        GIFCutMedia_slider_startSlider.valueProperty().addListener(new ChangeListener<Number>() {
            //initiate a listener to keep track of change on the start slider
            @Override
            public void changed(ObservableValue<? extends Number> location, Number arg1, Number arg2){
                startSliderVal = GIFCutMedia_slider_startSlider.getValue();
                startDu = (int) (mediaProcessor.getMedia().getDuration().toSeconds() * startSliderVal * 0.01);
            }
        });
    }

    @Override
    public void showNotification(Message msg) {
        
            String notiMsg = "";
            switch(msg.getStatus()){
                case SUCCESS -> {
                    notiMsg = "Success";
                    Notifications.create().title(notiMsg).text(msg.getMessage()).showConfirm();
                }
                case FAIL -> {
                    notiMsg = "Fail";
                    Notifications.create().title(notiMsg).text(msg.getMessage()).showError();
                }
                case INFO -> {
                    notiMsg = "Info";
                    Notifications.create().title(notiMsg).text(msg.getMessage()).showInformation();
                }
            }
    }

}

