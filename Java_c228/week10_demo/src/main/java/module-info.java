module com.example.week10_demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.week10_demo to javafx.fxml;
    exports com.example.week10_demo;
}