package com.example.vtf.Engine;

import com.example.vtf.Controller.MainPageController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

import static com.example.vtf.UI.PAGE_INDEX.MAIN_PAGE;

public class PageJump {
    private static Scene getScene(String destPageName) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        switch(destPageName){
            case MAIN_PAGE -> fxmlLoader.setController(new MainPageController());
            default -> throw new IOException("Page doesn't exist");
        }
        fxmlLoader.setLocation(PageJump.class.getResource("/frontend/" + destPageName +".fxml"));

        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        return scene;
    }
    public static Scene getMainPage() throws IOException{
        return getScene(MAIN_PAGE);
    }
}
