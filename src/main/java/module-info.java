module com.example.vtf {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires org.bytedeco.ffmpeg;
    requires org.bytedeco.javacv;

    opens com.example.vtf to javafx.fxml;
    exports com.example.vtf;
    exports com.example.vtf.InputProcess;
    opens com.example.vtf.Engine to javafx.fxml;
    opens com.example.vtf.Controller to javafx.fxml;
}