package com.example.wawinternet.Activity;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.example.wawinternet.Modeles.ModelCarte;
import com.example.wawinternet.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class Carte extends AppCompatActivity {
    private EditText recunumserie;
    private EditText recudebitcarte;
    private EditText recudureecarte;
    private Button recuvalidercarte;
    private Button recuannulercarte;

    private ModelCarte modelCarte;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carte);
        //recuvalidercarte.setOnClickListener(());
        //C'est pour le toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Carte");
        myToolbar.setNavigationIcon(R.drawable.back2);

        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Paiement.class));
            }
        });

        modelCarte=new ModelCarte();
        saveCarte();
    }
    int randomNum = ThreadLocalRandom.current().nextInt(1567893, 583696452 + 1);

    public class Constants{
        public static final String FIREBASE_CHILD_CARTE="cartes";
    }
    public void saveCarte(){
        recunumserie=(EditText) findViewById(R.id.editnumserie);
        recudebitcarte=(EditText) findViewById(R.id.editdebit);
        recudureecarte=(EditText) findViewById(R.id.editdureecarte);

        recuvalidercarte=(Button) findViewById(R.id.envoiCarte);
        recuannulercarte=(Button) findViewById(R.id.annuleCarte);

       /* modelCarte.setNumSerie(recunumserie.getText().toString());
        modelCarte.setDeitcarte(recudebitcarte.getText().toString());
        modelCarte.setDureecate(recudureecarte.getText().toString());*/
        recuvalidercarte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modelCarte.setNumSerie(recunumserie.getText().toString());
                modelCarte.setCode(randomNum);
                modelCarte.setDeitcarte(recudebitcarte.getText().toString());
                modelCarte.setDureecate(recudureecarte.getText().toString());

                mDatabase= FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_CARTE);
                mDatabase.push().setValue(modelCarte);
                Toast.makeText(Carte.this,"Carte bien crée",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
