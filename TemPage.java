package com.example.test01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TemPage extends AppCompatActivity {

    TextView myShowNameTV , myShowResultTem;

    Spinner mySpinnertem1,mySpinnertem2;

    EditText myInputCal;

    Button myInputBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tem_page);

        myShowNameTV = findViewById(R.id.showNameTV2);
        mySpinnertem1 = findViewById(R.id.spinnerTem1);
        mySpinnertem2 = findViewById(R.id.spinnerTem2);
        myInputCal = findViewById(R.id.inputCal);
        myInputBtn = findViewById(R.id.calBtn);
        myShowResultTem = findViewById(R.id.showResultTem);




        myInputBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sp1 = mySpinnertem1.getSelectedItem().toString();
                String sp2 = mySpinnertem2.getSelectedItem().toString();


                double inputtem = Double.parseDouble(myInputCal.getText().toString());
                double result1 = 0;


                if (sp1.equals("Celsius") && sp2.equals("Fahrenhiet")) {
                    result1 = (inputtem * 1.8) + 32;
                    myShowResultTem.setText(result1 + "");
                } else if (sp1.equals("Celsius") && sp2.equals("Kelvin")) {
                    result1 = inputtem + 273.15;
                    myShowResultTem.setText(result1 + "");
                } else if (sp1.equals("Fahrenhiet") && sp2.equals("Celsius")) {
                    result1 = (inputtem - 32) / 1.8;
                    myShowResultTem.setText(result1 + "");
                } else if (sp1.equals("Fahrenhiet") && sp2.equals("Kelvin")) {
                    result1 = ((inputtem - 32) / 1.8) + 273.15;
                    myShowResultTem.setText(result1 + "");
                } else if (sp1.equals("Kelvin") && sp2.equals("Celsius")) {
                    result1 = inputtem - 273.15;
                    myShowResultTem.setText(result1 + "");
                } else if (sp1.equals("Kelvin") && sp2.equals("Fahrenhiet")) {
                    result1 = ((inputtem - 273.15) * 1.8) + 32;
                    myShowResultTem.setText(result1 + "");
                }
            }
            });





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}