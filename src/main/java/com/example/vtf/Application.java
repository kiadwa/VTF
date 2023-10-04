package com.example.vtf;

import com.example.vtf.Engine.Engine;
import com.example.vtf.Engine.Window;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        Engine backEnd = new Engine();
        Window appWindow = new Window(backEnd);

        stage.setTitle("Video to GIF");
        stage.setScene(appWindow.getScene());
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}