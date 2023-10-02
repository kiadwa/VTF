package com.example.vtf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CodecConverter {
    public static void main(String[] args) {
        try {
            // Define the FFmpeg command as a list of strings
            // You can replace this with your own FFmpeg command
            List<String> command = new ArrayList<>();
            command.add("ffmpeg");
            command.add("-i");  // Input file
            command.add("C://Users//phkya//Documents//GitHub//vtf//src//main//resources/video.mp4"); // Replace with your input file path
            command.add("-c:v");  // Video codec
            command.add("libx264");
            command.add("-c:a");  // Audio codec
            command.add("aac");
            command.add("C://Users//phkya//Documents//GitHub//vtf//src//main//resources/video1.mp4"); // Replace with your output file path

            // Create a process builder for the FFmpeg command
            ProcessBuilder processBuilder = new ProcessBuilder(command);

            // Redirect the process's output and error streams
            processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);

            // Start the FFmpeg process
            Process process = processBuilder.start();

            // Wait for the process to complete
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("FFmpeg command executed successfully.");
            } else {
                System.err.println("FFmpeg command failed with exit code " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
