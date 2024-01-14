package com.example.practical1502;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void orderItems(View view) {
        CheckBox checkboxItem1 = findViewById(R.id.checkboxItem1);
        CheckBox checkboxItem2 = findViewById(R.id.checkboxItem2);
        CheckBox checkboxItem3 = findViewById(R.id.checkboxItem3);
        StringBuilder orderDetails = new StringBuilder("Selected Items:\n");
        if (checkboxItem1.isChecked()) {
            orderDetails.append("Pizza\n");
        }
        if (checkboxItem2.isChecked()) {
            orderDetails.append("Coffee\n");
        }
        if (checkboxItem3.isChecked()) {
            orderDetails.append("Burger\n");
        }

        double totalPrice = calculateTotalPrice(checkboxItem1.isChecked(), checkboxItem2.isChecked(), checkboxItem3.isChecked());
        orderDetails.append("Total Price: Rs").append(String.format("%.2f", totalPrice));
        Toast.makeText(this, orderDetails.toString(), Toast.LENGTH_LONG).show();
    }
    private double calculateTotalPrice(boolean item1Selected, boolean item2Selected, boolean item3Selected) {
        double pricePerItem1 = 99;
        double pricePerItem2 = 50;
        double pricePerItem3 = 120;
        int quantity1 = item1Selected ? 1 : 0;
        int quantity2 = item2Selected ? 1 : 0;
        int quantity3 = item3Selected ? 1 : 0;
        return (quantity1 * pricePerItem1) + (quantity2 * pricePerItem2) + (quantity3 * pricePerItem3);
    }
}