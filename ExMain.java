package com.example.test01;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainEx1 extends AppCompatActivity {

    TextView myShowName;

    Button myGoToSea , myGoBeSea , myOpenTem , myOpenEvent , myOpenLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_ex1);


        myShowName = findViewById(R.id.showNameTV);
        myGoToSea = findViewById(R.id.goToSea);
        myGoBeSea = findViewById(R.id.goBeSea);

        myOpenTem = findViewById(R.id.openTem);

        myOpenEvent = findViewById(R.id.openEvent);


        myOpenLogOut = findViewById(R.id.openLogOut);




        final SharedPreferences sp = this.getSharedPreferences("testEx1", Context.MODE_PRIVATE);
        String name = sp.getString("username","");

        myShowName.setText("Mr. "+name);



        myGoToSea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String geo = "geo:0,0?q=Seacon Srinakarin";
                Intent myIntend = new Intent(Intent.ACTION_VIEW, Uri.parse(geo));
                startActivity(myIntend);
            }
        });

        myGoBeSea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String geoCode = "http://maps.google.com/maps?saddr=13.69457453494044,100.64820353610403&daddr=13.738245890303645,100.62838909563206";
                Intent myIntend = new Intent(Intent.ACTION_VIEW, Uri.parse(geoCode));
                startActivity(myIntend);
            }
        });

        myOpenTem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntend = new Intent(getApplicationContext(), TemPage.class);
                startActivity(myIntend);
            }
        });

        myOpenEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntend = new Intent(getApplicationContext(), OpenEvent.class);
                startActivity(myIntend);
            }
        });

        myOpenLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntend = new Intent(getApplicationContext(), LogOutPage.class);
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