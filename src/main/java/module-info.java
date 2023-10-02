module com.example.vtf {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.example.vtf to javafx.fxml;
    exports com.example.vtf;
    exports com.example.vtf.InputProcess;
    opens com.example.vtf.InputProcess to javafx.fxml;
}