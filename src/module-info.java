module Dashboard
{
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.swing;
    requires  java.sql;
    requires mysql.connector.java;


    exports sample;
    opens sample;
}