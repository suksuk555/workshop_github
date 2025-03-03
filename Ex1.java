package com.example.test01;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ex1 extends AppCompatActivity {

    EditText myUserName , myPassword;

    Button myBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ex1);

        myUserName = findViewById(R.id.userED);
        myPassword = findViewById(R.id.passED);
        myBtn = findViewById(R.id.submitBT);

        final SharedPreferences sp = this.getSharedPreferences("testEx1", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();

        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName = myUserName.getText().toString();
                String Password = myPassword.getText().toString();

                if(myUserName.getText().toString().equals("")){
                    myUserName.setError("Num1 is null");
                }else if(myPassword.getText().toString().equals("")){
                    myPassword.setError("Num1 is null");
                }else {
                    editor.putString("username",userName);
                    editor.putString("password",Password);
                    editor.commit();

                    Intent myIntend = new Intent(getApplicationContext(), MainEx1.class);
                    startActivity(myIntend);
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