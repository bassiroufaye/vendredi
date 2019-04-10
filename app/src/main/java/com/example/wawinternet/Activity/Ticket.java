package com.example.wawinternet.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.wawinternet.Adaptateur.MyAdapter;
import com.example.wawinternet.Modeles.MyObject;
import com.example.wawinternet.R;

import java.util.ArrayList;
import java.util.List;

public class Ticket extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<MyObject> ListeTicket= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        //Remplir les tickets
        AjouterTicket();
        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(ListeTicket, this));
    }
    public void AjouterTicket(){
        ListeTicket.add(new MyObject("Perte de connexion",R.drawable.no_internet));
        ListeTicket.add(new MyObject("Connexion Lente",R.drawable.slow));
        ListeTicket.add(new MyObject("Débit faible",R.drawable.debit));
        ListeTicket.add(new MyObject("Suivie Tickets",R.drawable.contact));
    }
}
