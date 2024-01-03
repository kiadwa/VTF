package com.example.vtf.FFmpegStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class FFmpegWrapper {
    InputStream inputStream;
    static final String FFMPEG_PATH = "src/lib/ffmpeg-6.0-essentials_build/bin";
    String ffmpegCommand;

    public static boolean execute(String command) {

        File ffmpegFile = new File(FFMPEG_PATH);
        if (!ffmpegFile.exists()) {
            System.err.println("FFmpeg executable not found at: " + FFMPEG_PATH);
            return false;
        }
        try {
            File scriptFile = File.createTempFile("ffmpeg_script", ".bat");
            FileWriter scriptWriter = new FileWriter(scriptFile);
            scriptWriter.write(command);
            scriptWriter.close();

            scriptFile.setExecutable(true);
            ProcessBuilder processBuilder = new ProcessBuilder(scriptFile.getAbsolutePath());
            processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);
            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            scriptFile.delete();
            return exitCode == 0;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean codecConvert(String inputPath, String outputPath) {
        String convertCommand =  "ffmpeg.exe -i " + inputPath + " -c:v libx264 -c:a aac " + outputPath;
        return execute(convertCommand);
    }
    public static boolean cutMedia(String inputPath, String startTime, String duration, String outputPath){
        String cutCommand = "ffmpeg.exe -ss " + startTime + " -i " + inputPath + " -t " + duration + " -c:v libx264 -c:a aac " + outputPath;
        execute(cutCommand);
        return true;

    }

    public static void main(String[] args) {


        // Create an instance of the FFmpegWrapper
        FFmpegWrapper ffmpeg = new FFmpegWrapper();

        // Example: Convert a video file
        String inputVideo = "src/main/resources/video1.mp4"; // Replace with your input file path
        String outputVideo = "src/main/resources/output/output.mp4"; // Replace with your desired output file path
        String outputConverted = "src/main/resources/output/output1.mp4";

        ffmpeg.cutMedia(inputVideo,"1", "5", outputVideo);
        //ffmpeg.codecConvert(outputVideo,outputConverted);



    }
}
