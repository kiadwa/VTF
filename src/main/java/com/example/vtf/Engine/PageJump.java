package com.example.vtf.Engine;

import com.example.vtf.Controller.MainPageController;
import com.example.vtf.Controller.ViewController;
import com.example.vtf.UI.PAGE_INDEX;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.vtf.UI.PAGE_INDEX.MAIN_PAGE;
import static com.example.vtf.UI.PAGE_INDEX.MEDIA_VIEW;

public class PageJump {

    private static final int USER_HOME_WINDOW_WIDTH = 850;
    private static final int USER_HOME_WINDOW_HEIGHT = 650;
    private static Scene getScene(String destPageName) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        switch(destPageName){
            case MAIN_PAGE -> fxmlLoader.setController(MainPageController.getInstance());
            case MEDIA_VIEW -> fxmlLoader.setController(ViewController.getInstance());
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
    public static Scene switchPage(Event event, String destPageName) throws IOException{
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try{
            currentStage.setScene(PageJump.getScene(destPageName));
            currentStage.show();
        }catch (IOException | RuntimeException e){
            e.printStackTrace();
        }
        return null;
    }
}
