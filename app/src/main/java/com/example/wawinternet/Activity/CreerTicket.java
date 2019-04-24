package com.example.wawinternet.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wawinternet.Modeles.ModelTicket;
import com.example.wawinternet.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link CreerTicket#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreerTicket extends Fragment implements AdapterView.OnItemSelectedListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Spinner spin1,spin2;
    private EditText recupereref, recupereautre;
    private TextView text5;
    private Button boutvalticket;
    private Button boutannuleticket;
    private ModelTicket modelTicket;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public CreerTicket() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreerTicket.
     */
    // TODO: Rename and change types and number of parameters
    public static CreerTicket newInstance(String param1, String param2) {
        CreerTicket fragment = new CreerTicket();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
        String txt1=parent.getItemAtPosition(position).toString();
        Toast.makeText(getActivity(),"txt1"+txt1,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_creer_ticket, container, false);

        modelTicket =new ModelTicket();
        boutannuleticket=(Button) v.findViewById(R.id.idannuleticket);
        boutannuleticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText clear07=(EditText) v.findViewById(R.id.idref);
                clear07.setText("");
                EditText clear08=(EditText) v.findViewById(R.id.idautre);
                clear08.setText("");
            }
        });


        //get the spinner from the xml.
        final Spinner dropdown =(Spinner) v.findViewById(R.id.spinner1);
        Spinner dropdown2 =(Spinner) v.findViewById(R.id.spin);
        Spinner dropdown3 =(Spinner) v.findViewById(R.id.spin03);

        dropdown.setOnItemSelectedListener(this);

        //create a list of items for the spinner.
        String[] items = new String[]{"Perte de connexion", "Connexion lente", "Débit faible", "Connexion instable"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter< >(getActivity(), android.R.layout.simple_spinner_dropdown_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);

        //create a list of items for the spinner.
        String[] item2 = new String[]{"Moins de 1 heure", "Depuis 1 heure", "Depuis 2 heure","Depuis 3 heure", "Depuis 5 heure", "Plus de 5 heure", "Depuis 1 jour", "Depuis 1 mois", "Plus"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter< >(getActivity(), android.R.layout.simple_spinner_dropdown_item, item2);
        dropdown2.setAdapter(adapter2);

        String[] item3 = new String[]{"Très urgent", "Urgent", "Moins urgent"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter< >(getActivity(), android.R.layout.simple_spinner_dropdown_item, item3);
        dropdown3.setAdapter(adapter3);

        //afficherticket();
        recupereref=(EditText) v.findViewById(R.id.idref);
        recupereautre=(EditText) v.findViewById(R.id.idautre);
       String text1 = dropdown.getSelectedItem().toString();
        String text2 = dropdown2.getSelectedItem().toString();
        boutvalticket=(Button) v.findViewById(R.id.button5);
        boutvalticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(),recupereref.getText(),Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(),recupereautre.getText(),Toast.LENGTH_LONG).show();
                //Toast.makeText(CreerTicket.this,text1.getText(),Toast.LENGTH_LONG).show();
                //Toast.makeText(CreerTicket.this,text2.getText(),Toast.LENGTH_LONG).show();
            }
        });
        return v;
    }


}
