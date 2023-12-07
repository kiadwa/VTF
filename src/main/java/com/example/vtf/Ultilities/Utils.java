package com.example.vtf.Ultilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Utils {

    /**Use to get file extension*/
    public static String getFileExtension(String fileName){
        int dotIndex = fileName.lastIndexOf('.');
        if(dotIndex == -1 || dotIndex == fileName.length()-1){
            return "";
        }else{
            return fileName.substring(dotIndex + 1);
        }
    }
    /**Use to get media file duration into String*/
    public static String getMediaFileDuration(File file){
        return null;
    }

    public static String getFileSize(File file){
        Path path = FileSystems.getDefault().getPath(file.getAbsolutePath());
        try{
            long fileSize = Files.size(path);
            return String.valueOf(fileSize * 0.000001);
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
