module ucr.lab.pg02 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ucr.lab.pg02 to javafx.fxml;
    exports ucr.lab.pg02;
    exports controller;
    opens controller to javafx.fxml;
}