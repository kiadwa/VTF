package com.example.vtf.Engine;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Window {
    private Engine engine;
    private final int WIDTH = 500;
    private final int HEIGHT = 300;
    Scene scene;
    Pane pane;
    DragDropBox dragAndDropBox;

    public Window(Engine engine){
        this.engine = engine;
        this.pane = new Pane();
        this.dragAndDropBox = new DragDropBox();
        dragAndDropBox.dragAndDrop();
        dragAndDropBox.TestPrint();
        this.scene = new Scene(pane, WIDTH,HEIGHT);
        pane.getChildren().add(dragAndDropBox.getBox());
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
