module Dashboard
{
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.swing;
    requires  java.sql;
    requires mysql.connector.j;

    exports sample;
    opens sample;
}