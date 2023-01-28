package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

public class TablesController extends SceneController implements Initializable
{

    public TableView tableView;
    public TableColumn<Expense, LocalDate> dataOfExpenseCol;
    public TableColumn<Expense,Double> groceriesCol;
    public TableColumn<Expense,Double> billsCol;
    public TableColumn<Expense,Double> entertainmentCol;
    public TextField dateField;
    public TextField groceriesField;
    public TextField billsField;
    public TextField entertainmentField;







    @Override
    public void changeSceneToTables(ActionEvent event) throws IOException
    {
        super.changeSceneToTables(event);
    }

    @Override
    public void changeSceneToDashboard(ActionEvent event) throws IOException
    {
        super.changeSceneToDashboard(event);
    }

    @Override
    public void changeSceneToGoals(ActionEvent event) throws IOException
    {
        super.changeSceneToGoals(event);
        new Expense(LocalDate.of(2023, Month.JANUARY,28), 100,200,300);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {


        try
        {
            loadUserTable();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }


    }


    public void loadUserTable() throws SQLException
    {
        ObservableList<Expense> observableList = FXCollections.observableArrayList();

        dataOfExpenseCol.setCellValueFactory(new PropertyValueFactory<>("DataOfExpense"));
        groceriesCol.setCellValueFactory(new PropertyValueFactory<>("Groceries"));
        billsCol.setCellValueFactory(new PropertyValueFactory<>("Bills"));
        entertainmentCol.setCellValueFactory(new PropertyValueFactory<>("Entertainment"));

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/financial_calculator?serverTimezone=UTC", "root", "password");

        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT date_of_expense, groceries,bills, entertainment FROM expensesTable");

        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());


        while(rs.next())
        {
            observableList.add(new Expense(rs.getDate("date_of_expense").toLocalDate(),rs.getDouble("groceries"), rs.getDouble("bills"),rs.getDouble("entertainment")));
        }

        tableView.setItems(observableList);

    }

    public void addExpense(ActionEvent event) throws SQLException
    {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/financial_calculator?serverTimezone=UTC", "root", "password");

        Statement stmt = connection.createStatement();

        String query = "INSERT INTO expensesTable (date_of_expense, groceries, bills, entertainment, user_id) VALUES ('" + dateField.getText()+"',"+ groceriesField.getText() + ","+ billsField.getText() + ","+ entertainmentField.getText() + ",0)";

        stmt.executeUpdate(query);


       String splitDate[]  =splitIntoDayMonthYear(dateField.getText());


        tableView.getItems().add(new Expense(LocalDate.of(Integer.valueOf(splitDate[0]),takeMonth(splitDate[1]),Integer.valueOf(splitDate[2])),Double.valueOf(groceriesField.getText()) ,Double.valueOf(billsField.getText()) ,Double.valueOf(entertainmentField.getText())));


        dateField.setText("");
        groceriesField.setText("");
        billsField.setText("");
        entertainmentField.setText("");

    }


    private String[] splitIntoDayMonthYear(String date)
    {
       String splitDate[] = date.split("-");
       return splitDate;
    }

    private Month takeMonth(String month)
    {
        switch (month)
        {
            case "1":
                return Month.JANUARY;

            case "2":
                return Month.FEBRUARY;

            case "3":
                return Month.MARCH;


            case "4":
                return Month.APRIL;


            case "5":
                return Month.MAY;


            case "6":
                return Month.JUNE;


            case "7":
                return Month.JULY;


            case "8":
                return Month.AUGUST;


            case "9":
                return Month.SEPTEMBER;

            case "10":
                return Month.OCTOBER;



                case "11":
                    return Month.NOVEMBER;


            case "12":
                return Month.DECEMBER;


            default:
                return Month.JANUARY;

        }
    }


}
