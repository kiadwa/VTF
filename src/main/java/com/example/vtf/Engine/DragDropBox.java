package com.example.vtf.Engine;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;

public class DragDropBox {
    Rectangle box;
    final double WIDTH;
    final double HEIGHT;
    final double x;
    final double y;

    File inputFile;
    String filePath;

    public DragDropBox(){
        WIDTH = 500;
        HEIGHT = 100;
        y = 200;
        x = 0;
        box = new Rectangle(500,100);
        box.setFill(Color.LIGHTGRAY);
        box.setX(x);
        box.setY(y);

    }
    public void dragAndDrop(){
        box.setOnDragOver(event -> {
            if (event.getDragboard().hasFiles()) {
                event.acceptTransferModes(javafx.scene.input.TransferMode.COPY);
            }
            event.consume();
        });

        box.setOnDragDropped(event -> {
            if (event.getDragboard().hasFiles()) {
                // Handle the dropped files here
                event.getDragboard().getFiles().forEach(file -> {
                        inputFile = file;
                        filePath = inputFile.getAbsolutePath();

                    // Save the file for later use, e.g., copy it to a specific directory
                    // You can implement this part based on your requirements
                });
                event.setDropCompleted(true);
            }
            event.consume();
        });
    }

    public Rectangle getBox(){return this.box;}
    public void TestPrint(){
        System.out.println(filePath);
    }
}
