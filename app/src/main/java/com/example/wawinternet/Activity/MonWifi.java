package com.example.wawinternet.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.wawinternet.Activity.MainActivity;
import com.example.wawinternet.R;

public class MonWifi extends AppCompatActivity {
    private Button recubutretour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_wifi);

        //C'est pour le toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Mon Wifi");
        myToolbar.setNavigationIcon(R.drawable.back2);

        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        recubutretour=(Button) findViewById(R.id.button4);
        recubutretour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent accueil=new Intent(MonWifi.this,MainActivity.class);
                startActivity(accueil);
            }
        });
    }
}
