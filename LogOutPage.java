package com.example.test01;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LogOutPage extends AppCompatActivity {

    Button myYes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_out_page);

        myYes = findViewById(R.id.yesBtn);

        final SharedPreferences sp = this.getSharedPreferences("testEx1", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();

        myYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // บันทึกข้อมูล
                editor.putString("username",""); //column
                editor.putString("password",""); //column
                editor.commit();

                Intent myIntend = new Intent(getApplicationContext(), Ex1.class);
                startActivity(myIntend);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}