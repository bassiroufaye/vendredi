package com.example.wawinternet.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.wawinternet.Modeles.MyObject;
import com.example.wawinternet.Adaptateur.MyAdapterTicket;
import com.example.wawinternet.R;

import java.util.ArrayList;
import java.util.List;

public class Contact extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<MyObject> ListeTicket= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Contact");
        myToolbar.setNavigationIcon(R.drawable.back2);

        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
        //Remplir les informations
        AjouterTicket();
        recyclerView=(RecyclerView) findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapterTicket(ListeTicket, this));

    }
    public void AjouterTicket(){
        ListeTicket.add(new MyObject("Perte de connexion",R.drawable.no_internet));
        ListeTicket.add(new MyObject("Connexion Lente",R.drawable.slow));
        ListeTicket.add(new MyObject("Débit faible",R.drawable.debit));
        ListeTicket.add(new MyObject("Suivie Tickets",R.drawable.contact));
    }
}
