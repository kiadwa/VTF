package com.example.vtf.Engine;

import com.example.vtf.FFmpegStream.FFmpegWrapper;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MediaProcessor {
    Media media;
    private static MediaProcessor instance;
    FFmpegWrapper fFmpegWrapper = new FFmpegWrapper();
    String filePath = "";
    String outputPath = "";
    String fileName = "";

    private MediaProcessor(){}

    public static MediaProcessor getInstance() {
        if (instance == null) {
            instance = new MediaProcessor();
        }
        return instance;
    }
    public void setFileName(String fileName){
        this.fileName = fileName;
    }
    public String getFileName(){
        return this.fileName;
    }
    public void setMedia(Media media){
        this.media = media;
    }
    public void setOutputPath(String filePath){
        this.outputPath = filePath;
    }
    public String getOutputPath(){
        return this.outputPath;
    }
    public void setFilePath(String filePath){
        this.filePath = filePath;
    }
    public String getFilePath(){
        return this.filePath;
    }

    public Media getMedia(){
        return media;
    }

    public MediaPlayer getMediaPlayer() {
        return new MediaPlayer(media);
    }
}
