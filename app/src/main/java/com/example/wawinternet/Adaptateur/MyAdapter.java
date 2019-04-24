package com.example.wawinternet.Adaptateur;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wawinternet.Activity.Abonner;
import com.example.wawinternet.Activity.Contact;
import com.example.wawinternet.Activity.Information;
import com.example.wawinternet.Activity.Messagerie;
import com.example.wawinternet.Activity.Paiement;
import com.example.wawinternet.Activity.Ticket;
import com.example.wawinternet.ItemClickListener;
import com.example.wawinternet.Modeles.MyObject;
import com.example.wawinternet.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<MyObject> list;
    private Context context;
    Intent intent1;
    Intent intent2;
    Intent intent3;
    Intent intent4;
    Intent intent5;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView textViewView;
        private CardView cardView;
        private ImageView imageView;
        private ItemClickListener itemClickListener;

        //itemView est la vue correspondante à 1 cellule
        public MyViewHolder(View itemView) {
            super(itemView);

            //c'est ici que l'on fait nos findView

            textViewView = (TextView) itemView.findViewById(R.id.text);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            cardView = (CardView) itemView.findViewById(R.id.mycard);

            //C'est ici qu'on permet l'écoute des items
            itemView.setOnClickListener(this);
        }


        //puis ajouter une fonction pour remplir la cellule en fonction d'un MyObject
        public void bind(MyObject myObject){
            textViewView.setText(myObject.getText());
            // Picasso.with(imageView.getContext()).load(myObject.getImageUrl()).centerCrop().fit().into(imageView);
            imageView.setImageResource(myObject.getImageUrl());

            //C'est ici qu'on navigue sur les différentes activités
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();
                    if(position==0){
                        Intent intent=new Intent(context, Paiement.class);
                        context.startActivity(intent);

                    }
                    else{
                        if(position==1){
                            intent1 =new Intent(context, Ticket.class);
                            context.startActivity(intent1);
                        }
                        else{
                            if(position==2){
                                intent2 =new Intent(context, Messagerie.class);
                                context.startActivity(intent2);
                            }
                            else{
                                if(position==3){
                                    intent3 =new Intent(context, Information.class);
                                    context.startActivity(intent3);
                                }
                                else{
                                    if(position==4){
                                        intent4 =new Intent(context, Abonner.class);
                                        context.startActivity(intent4);
                                    }
                                    else{
                                        if(position==5){
                                            intent5 =new Intent(context, Contact.class);
                                            context.startActivity(intent5);
                                        }
                                    }
                                }
                            }
                        }

                    }

                    // Toast.makeText(context,"cliquez",Toast.LENGTH_LONG).show();
                    //Intent intent=new Intent(context, Paiement.class);
                    //context.startActivity(intent);

                }
            });
        }

        @Override
        public void onClick(View v) {

            //itemClickListener.onClick(v,getAdapterPosition(),false);
        }
    }


    //ajouter un constructeur prenant en entrée une liste
    public MyAdapter(List<MyObject> list, Context context) {
        this.context=context;
        this.list = list;
    }

    //cette fonction permet de créer les viewHolder
    //et par la même indiquer la vue à inflater (à partir des layout xml)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_cards,viewGroup,false);
        return new MyViewHolder(view);
    }

    //c'est ici que nous allons remplir notre cellule avec le texte/image de chaque MyObjects
    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        MyObject myObject = list.get(position);
        myViewHolder.bind(myObject);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
