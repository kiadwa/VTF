package com.example.vtf.Engine;

import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.stage.Window;

public class Engine {
    Scene appScene;
    Window appWindow;
    Media orgMedia;
    Media outputGIF;


    public  Engine(){


    }


    public void sliceVideo(Media media){

    }

    public void transformToGIF(Media media){

    }

    public void setOrgMedia(Media media){
        this.orgMedia = media;
    }
    public void setOutputGIF(Media media){
        this.outputGIF = media;
    }
    public Media getOrgMedia(){return this.orgMedia;}
    public Media getOutputGIF(){return this.outputGIF;}

}
