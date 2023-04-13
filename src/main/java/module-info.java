module project.jsimon {
    requires javafx.controls;
    requires javafx.fxml;


    opens project.jsimon to javafx.fxml;
    exports project.jsimon;
}