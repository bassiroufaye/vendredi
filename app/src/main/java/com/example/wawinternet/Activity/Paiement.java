package com.example.wawinternet.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wawinternet.Modeles.ModelCarte;
import com.example.wawinternet.Modeles.ModelPaiement;
import com.example.wawinternet.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.System.in;

public class Paiement extends AppCompatActivity {

    private TextView textView;

    private RadioGroup radiopersoGroup;
    private RadioButton radiopersoButton;
    private RadioGroup radiodebitGroup;
    private RadioButton radiodebitButton;
    private EditText editref;
    private EditText editcode;
    private Button boutclearpai;
    private Button boutvalidepai;

    private ModelPaiement modelpaiement;
    private DatabaseReference mDatabase,mCarte;
    private String rface;

    private TextView recuperqui;
    private TextView recuperdebit;
    private TextView recuperref;
    private TextView recupercode;
    //private Context context;
    private ArrayList<ModelCarte> carteList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paiement);

        modelpaiement=new ModelPaiement();
        ModelCarte modelCarte=new ModelCarte();
        carteList=new ArrayList<>();

        textView=(TextView) findViewById(R.id.redirect);
        boutclearpai=(Button) findViewById(R.id.boutAnPai);
        boutclearpai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText clear05=(EditText) findViewById(R.id.editText1);
                clear05.setText("");
                EditText clear06=(EditText) findViewById(R.id.editText2);
                clear06.setText("");
            }
        });

        //C'est pour le toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Paiement");
        myToolbar.setNavigationIcon(R.drawable.back2);

        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Paiement.this, Reference.class);
                startActivity(intent);
            }
        });
        affichersaisi();
        //getDataFromServer();
    }

    public class Constants {

        public static final String FIREBASE_CHILD_PAIEMENT = "paiements";
        public static final String FIREBASE_CHILD_CARTE = "cartes";
    }


    public void affichersaisi(){
        //récupération des radioGroup
        radiopersoGroup=(RadioGroup) findViewById(R.id.radioGroup);
        radiodebitGroup=(RadioGroup) findViewById(R.id.radioGroup2);
        //récupération des editText
        editref=(EditText) findViewById(R.id.editText1);
        editcode=(EditText) findViewById(R.id.editText2);
        //récupération du bouton paiement
        boutvalidepai=(Button) findViewById(R.id.button);
        boutvalidepai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //récupération de l'identifiant du boton qui est séléctionné
                int selectedIdperso=radiopersoGroup.getCheckedRadioButtonId();
                int selectedIddebit=radiodebitGroup.getCheckedRadioButtonId();
                radiopersoButton=(RadioButton) findViewById(selectedIdperso);
                radiodebitButton=(RadioButton) findViewById(selectedIddebit);


                    mDatabase = FirebaseDatabase
                            .getInstance()
                            .getReference(Constants.FIREBASE_CHILD_PAIEMENT);

                    modelpaiement.setQuipaie(radiopersoButton.getText().toString());
                    modelpaiement.setDebit(radiodebitButton.getText().toString());
                    modelpaiement.setReference(editref.getText().toString());
                    modelpaiement.setCodecarte(editcode.getText().toString());
                    if (modelpaiement.getReference().isEmpty() || modelpaiement.getCodecarte().isEmpty())
                        Toast.makeText(Paiement.this, "Meri de renseigner tous les champs", Toast.LENGTH_SHORT).show();
                    else
                    {
                        if (modelpaiement.getCodecarte().equals("500")){
                            mDatabase.push().setValue(modelpaiement);
                            Toast.makeText(Paiement.this, "Votre paiement a réussi avec succes", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(Paiement.this, "Code invalide", Toast.LENGTH_SHORT).show();
                        //Affichage à partir du model avec get()
                        // Toast.makeText(Paiement.this,modelpaiement.getQuipaie(),Toast.LENGTH_LONG).show();
                    }
                    }



        });

    }
    /*public void getDataFromServer()
    {
        mCarte = FirebaseDatabase.getInstance().getReference();

        mCarte.child("cartes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    for(DataSnapshot postSnapShot:dataSnapshot.getChildren())
                    {
                        ModelCarte user=postSnapShot.getValue(ModelCarte.class);

                        carteList.add(user);
                        Toast.makeText(Paiement.this, user+"", Toast.LENGTH_SHORT).show();
                    }
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }*/
}
