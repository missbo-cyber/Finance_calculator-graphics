package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Expense
{
    private LocalDate dataOfExpense;
   private SimpleDoubleProperty groceries;
   private SimpleDoubleProperty bills;
   private SimpleDoubleProperty entertainment;


    public Expense(LocalDate dataOfExpense, double groceries, double bills,double entertainment)
    {
        this.dataOfExpense = dataOfExpense;
        this.groceries = new SimpleDoubleProperty(groceries);
        this.bills = new SimpleDoubleProperty(bills);
        this.entertainment = new SimpleDoubleProperty(entertainment);
    }



    public LocalDate getDataOfExpense()
    {
        return dataOfExpense;
    }

    public void setDataOfExpense(LocalDate dataOfExpense)
    {
        this.dataOfExpense = dataOfExpense;
    }

    public double getGroceries()
    {
        return groceries.get();
    }



    public void setGroceries(double groceries)
    {
        this.groceries.set(groceries);
    }

    public double getBills()
    {
        return bills.get();
    }


    public void setBills(double bills)
    {
        this.bills.set(bills);
    }

    public double getEntertainment()
    {
        return entertainment.get();
    }



    public void setEntertainment(double entertainment)
    {
        this.entertainment.set(entertainment);
    }
}
