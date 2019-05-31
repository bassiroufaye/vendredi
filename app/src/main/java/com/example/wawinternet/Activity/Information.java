package com.example.wawinternet.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wawinternet.R;

public class Information extends AppCompatActivity {
    private Button b1;
    private EditText recuref;
    private EditText ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Mon Wifi");
        myToolbar.setNavigationIcon(R.drawable.back2);

        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        recuref=(EditText) findViewById(R.id.idref);
       // ed2=ed1.getText().toString();
            b1=(Button) findViewById(R.id.button2);
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(recuref.getText().toString().equals("AB259944")){
                            Intent intent=new Intent(Information.this, MonWifi.class);
                            startActivity(intent);
                        }
                        else
                            Toast.makeText(Information.this, "La référence entrée est invalide", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
