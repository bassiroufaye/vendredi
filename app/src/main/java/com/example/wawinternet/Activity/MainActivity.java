package com.example.wawinternet.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.wawinternet.Modeles.MyObject;
import com.example.wawinternet.Adaptateur.MyAdapter;
import com.example.wawinternet.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<MyObject> menu = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //remplir la ville
        ajouterVilles();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //définit l'agencement des cellules, ici de façon verticale, comme une ListView
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //pour adapter en grille comme une RecyclerView, avec 2 cellules par ligne
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        //puis créer un MyAdapter, lui fournir notre liste de villes.
        //cet adapter servira à remplir notre recyclerview
        recyclerView.setAdapter(new MyAdapter(menu,this));
    }

    private void ajouterVilles() {
        menu.add(new MyObject("Paiement",R.drawable.pai));
        menu.add(new MyObject("Ticket",R.drawable.tick));
        menu.add(new MyObject("Messagerie",R.drawable.message));
        menu.add(new MyObject("Information",R.drawable.info));
        menu.add(new MyObject("S'Abonner",R.drawable.abonner));
        menu.add(new MyObject("Contact",R.drawable.contact));
        //cities.add(new MyObject("Ticket","http://www.traditours.com/images/Photos%20Angleterre/ForumLondonBridge.jpg"));
        //cities.add(new MyObject("Messagerie","http://tanned-allemagne.com/wp-content/uploads/2012/10/pano_rathaus_1280.jpg"));
        //cities.add(new MyObject("Information","http://www.sejour-linguistique-lec.fr/wp-content/uploads/espagne-02.jpg"));
        // cities.add(new MyObject("S'Abonner","http://retouralinnocence.com/wp-content/uploads/2013/05/Hotel-en-Italie-pour-les-Vacances2.jpg"));
        // cities.add(new MyObject("Contact","http://www.choisir-ma-destination.com/uploads/_large_russie-moscou2.jpg"));
    }
}

