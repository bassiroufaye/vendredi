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

import com.example.wawinternet.Modeles.ModelPaiement;
import com.example.wawinternet.R;

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

    private TextView recuperqui;
    private TextView recuperdebit;
    private TextView recuperref;
    private TextView recupercode;
    //private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paiement);

        modelpaiement=new ModelPaiement();

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

                //Identification du bouton à partir de l'id
                radiopersoButton=(RadioButton) findViewById(selectedIdperso);
                radiodebitButton=(RadioButton) findViewById(selectedIddebit);

                modelpaiement.setQuipaie(radiopersoButton.getText().toString());
                modelpaiement.setDebit(radiodebitButton.getText().toString());
                modelpaiement.setReference(editref.getText().toString());
                modelpaiement.setCodecarte(editcode.getText().toString());

                //Affichage des valeurs
                Toast.makeText(Paiement.this,modelpaiement.getQuipaie(),Toast.LENGTH_LONG).show();
                Toast.makeText(Paiement.this,modelpaiement.getDebit(),Toast.LENGTH_LONG).show();
                Toast.makeText(Paiement.this,modelpaiement.getReference(),Toast.LENGTH_LONG).show();
                Toast.makeText(Paiement.this,modelpaiement.getCodecarte(),Toast.LENGTH_LONG).show();
                //modelpaiement.getQuipaie(Toast.makeText(Paiement.this,radiopersoButton.getText().toString(),Toast.LENGTH_LONG).show());
                //modelpaiement.getDebit();

                //Toast.makeText(this,getText(String quipaie));

            }
        });

    }


}
