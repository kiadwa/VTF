package com.example.vtf.Controller;


import com.example.vtf.Engine.Message;
import com.example.vtf.Engine.Message.Status;

import javafx.stage.Stage;

import javafx.scene.control.Label;
import org.controlsfx.control.Notifications;


public interface Notificator {
    Stage notiStage = new Stage();
    Label innerText = new Label();

    public void showNotification(Message msg);


}
