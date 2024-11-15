module com.example.wei_07_lab4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.wei_07_lab4 to javafx.fxml;
    exports com.example.wei_07_lab4;
}