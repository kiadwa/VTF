package com.example.vtf.Engine;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Window {
    private Engine engine;
    private final int WIDTH = 500;
    private final int HEIGHT = 300;
    Scene scene;
    Pane pane;

    public Window(Engine engine){
        this.engine = engine;
        this.pane = new Pane();
        this.scene = new Scene(pane, WIDTH,HEIGHT);

    }

    public Scene getScene(){
        return this.scene;
    }
    public Engine getEngine(){
        return this.engine;
    }

    public void draw(){

    }
}
