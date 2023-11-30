package com.example.vtf.Engine;

import com.example.vtf.FFmpegStream.FFmpegWrapper;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class MediaProcessor {
    Media media;
    private static MediaProcessor instance;
    FFmpegWrapper fFmpegWrapper = new FFmpegWrapper();

    private MediaProcessor(){}

    public static MediaProcessor getInstance() {
        if (instance == null) {
            instance = new MediaProcessor();
        }

        return instance;
    }
    public void setMedia(Media media){
        this.media = media;
    }
    public void show(Pane root, Scene scene){
        if (media != null){
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);

            root.getChildren().add(mediaView);

        }
    }

}
