package com.example.vtf.Ultilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.bytedeco.ffmpeg.global.avutil;
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
}
