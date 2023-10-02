package com.example.vtf;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.scene.media.Media;

import java.io.File;
import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        Media media = new Media(new File("src/main/resources/video1.mp4").toURI().toString());
        MediaPlayer mp = new MediaPlayer(media);
        MediaView mv = new MediaView(mp);
        StackPane root = new StackPane();
        root.getChildren().add(mv);
        //stage.setTitle("Hello!");
        Scene scene = new Scene(root, 1200, 600);
        stage.setScene(scene);
        mp.play();
        stage.show();
        mp.play();

    }

    public static void main(String[] args) {
        launch();
    }
}