package com.mathiewdoyle.tipsplitcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    private EditText bill_total_app;
    private TextView tip_amount_app;
    private TextView total_with_tip_app;
    private EditText numCustomers_app;
    private TextView total_per_person_app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bill_total_app = findViewById(R.id.bill_total); // creating reference to EditText 'bill_total' which will give us our total with tax as entered by the user
        tip_amount_app = findViewById(R.id.tip_amount); // creating reference to TextView 'tip_amount' which will display our result (the tip amount)
        total_with_tip_app = findViewById(R.id.total_with_tip); // creating reference to TextView 'total_with_tip' which will display our result (the total bill with tip included)
        numCustomers_app = findViewById(R.id.numCustomers_in); // creating reference to EditText 'numCustomers_in' which will give us the number of customers to split the bill with
        total_per_person_app = findViewById(R.id.total_per_person); // creating reference to TextView 'total_per_person' which will display the total owed per customer
    }

    double total_including_tip; // since this variable is used in multiple methods, we must declare it outside of any function

    // method to calculate our total including tip 
    public void totalCalculator(View v) {
        // making sure nothing crashes if our EditText is empty and the user clicks a button
        if(bill_total_app.getText().toString().isEmpty()){
            return;
        }

        String total_inc_taxStr = bill_total_app.getText().toString(); // taking this amount ('bill_total') and converting it into a String
        double total_inc_tax = Double.parseDouble(total_inc_taxStr); // converts the aforementioned string (taken from 'bill_total') and parses it as a Double
        double tipAmount;

        if(v.getId() == R.id.twelve_percent){
            tipAmount = total_inc_tax * 0.12; // calculates the tip owed
            tip_amount_app.setText(String.format(Locale.ENGLISH, "$" + "%.2f", tipAmount)); // sets text in textView tip_amount to our result (the tip owed)
            total_including_tip = total_inc_tax + tipAmount; // adds total including tax to the tip amount
            total_with_tip_app.setText(String.format(Locale.ENGLISH,"$" + "%.2f", total_including_tip)); // converts our double result into a String, shaves off all decimal places but two, and displays on the screen
        }
        else if(v.getId() == R.id.fifteen_percent){
            tipAmount = total_inc_tax * 0.15; // calculates the tip owed
            tip_amount_app.setText(String.format(Locale.ENGLISH, "$" + "%.2f", tipAmount)); // sets text in textView tip_amount to our result (the tip owed)
            total_including_tip = total_inc_tax + tipAmount; // adds total including tax to the tip amount
            total_with_tip_app.setText(String.format(Locale.ENGLISH,"$" + "%.2f", total_including_tip)); // converts our double result into a String, shaves off all decimal places but two, and displays on the screen
        }
        else if(v.getId() == R.id.eighteen_percent){
            tipAmount = total_inc_tax * 0.18; // calculates the tip owed
            tip_amount_app.setText(String.format(Locale.ENGLISH, "$" + "%.2f", tipAmount)); // sets text in textView tip_amount to our result (the tip owed)
            total_including_tip = total_inc_tax + tipAmount; // adds total including tax to the tip amount
            total_with_tip_app.setText(String.format(Locale.ENGLISH,"$" + "%.2f", total_including_tip)); // converts our double result into a String, shaves off all decimal places but two, and displays on the screen
        }
        else if(v.getId() == R.id.twenty_percent){
            tipAmount = total_inc_tax * 0.20; // calculates the tip owed
            tip_amount_app.setText(String.format(Locale.ENGLISH, "$" + "%.2f", tipAmount)); // sets text in textView tip_amount to our result (the tip owed)
            total_including_tip = total_inc_tax + tipAmount; // adds total including tax to the tip amount
            total_with_tip_app.setText(String.format(Locale.ENGLISH,"$" + "%.2f", total_including_tip)); // converts our double result into a String, shaves off all decimal places but two, and displays on the screen
        }
    }

    // method to split our bill between some nonzero value of people
    public void splitBill(View v){
        // ensuring clicking buttons while text fields remain empty doesn't crash our program
        if(bill_total_app.getText().toString().isEmpty()){
            return;
        }
        if(total_with_tip_app.getText().toString().isEmpty()){
            return;
        }
        if(tip_amount_app.getText().toString().isEmpty()){
            return;
        }
        if(numCustomers_app.getText().toString().isEmpty()){
            return;
        }
        // variable initialization for new method
        String numCustomers;
        int numToSplit;
        double total_per_customer;

        numCustomers = numCustomers_app.getText().toString(); // retrieving the number of customers on bill from our EditText
        numToSplit = Integer.parseInt(numCustomers); // converting numCustomers from EditText to integer
        total_per_customer = total_including_tip / numToSplit; // divides our total including tip by the number of customers splitting the bill
        total_per_person_app.setText(String.format(Locale.ENGLISH, "$" + "%.2f",total_per_customer)); // converts our double result into a String, shaves off all decimal places but two, and displays on the screen
    }

    // method to clear our EditTexts and TextViews so that the user can restart with a different bill and / or tip amount
    public void clearValues(View v){
        bill_total_app.setText("");
        tip_amount_app.setText("");
        total_with_tip_app.setText("");
        numCustomers_app.setText("");
        total_per_person_app.setText("");
    }
}