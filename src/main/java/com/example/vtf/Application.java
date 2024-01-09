package com.example.vtf;

import com.example.vtf.Engine.*;
import com.example.vtf.Engine.PageJump;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setScene(PageJump.getMainPage());
        stage.setTitle("Video to GIF");
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}