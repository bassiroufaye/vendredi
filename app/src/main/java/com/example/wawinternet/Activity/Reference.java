package com.example.wawinternet.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.wawinternet.R;

public class Reference extends AppCompatActivity {

    private Button boutclear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reference);


        //C'est le toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Référencement");
        myToolbar.setNavigationIcon(R.drawable.back2);

        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        boutclear=(Button) findViewById(R.id.boutAnRef);
        boutclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText clear01=(EditText) findViewById(R.id.editText3);
                clear01.setText("");
                EditText clear02=(EditText) findViewById(R.id.editText4);
                clear02.setText("");
                EditText clear03=(EditText) findViewById(R.id.editText5);
                clear03.setText("");

            }
        });


    }
}
