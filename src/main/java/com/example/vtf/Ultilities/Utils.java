package com.example.vtf.Ultilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.bytedeco.javacv.FFmpegFrameGrabber;

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

    public static String swapExtensionIntoGIF(String fileName){
        String gif = "gif";

        int dotIndex = fileName.lastIndexOf('.');
        if(dotIndex != -1){
            String baseFileName = fileName.substring(0,dotIndex);
            String newFileName = baseFileName + "." + gif;
            return newFileName;
        }else{
            return fileName + "." + gif;
        }
    }
    /**Use to get File size*/
    public static String getFileSize(File file){
        Path path = FileSystems.getDefault().getPath(file.getAbsolutePath());
        try{
            DecimalFormat df = new DecimalFormat("#.##");
            long fileSize = Files.size(path);
            return df.format(fileSize * 0.000001);
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }


    public static List<String> getDurationConversion(List<Double> input, double startPercentage, double endingPercentage){

        List<String> result = new ArrayList<>();

        double startDuration = input.get(0);
        double endDuration = input.get(1);

        startDuration = startDuration * startPercentage;
        endDuration = endDuration * endingPercentage;

        return result;
    }

    public static double getMediaDuration(String filePath) {
        try (FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(filePath)) {
            grabber.start();
            double duration = grabber.getLengthInTime() / (double) 1000000; //avutil.AV_TIME_BASE;
            return duration;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    /**Get Media Name from output Path to modified the output name so that it doesn't duplicate with input*/
    public static String getMediaNameFromPath(String filePath){
        int dashIndex = filePath.lastIndexOf('/');
        if(dashIndex == -1 || dashIndex == filePath.length() - 1){
            return "";
        }else{
            return filePath.substring(dashIndex + 1);
        }
    }
}
