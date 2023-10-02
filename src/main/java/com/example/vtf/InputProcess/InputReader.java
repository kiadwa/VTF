package com.example.vtf.InputProcess;

import javafx.scene.media.Media;

import java.io.File;

public class InputReader {
    Media inputVideo;

    public void setInputVideo(String filepath){
        this.inputVideo = new Media(new File(filepath).toURI().toString());
    }
    public Media getInputVideo(){
        return inputVideo;
    }


}
