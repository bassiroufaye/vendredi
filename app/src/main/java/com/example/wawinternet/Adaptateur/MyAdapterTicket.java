package com.example.wawinternet.Adaptateur;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wawinternet.Modeles.MyObject;
import com.example.wawinternet.R;

import java.util.List;

public class MyAdapterTicket extends RecyclerView.Adapter<MyAdapterTicket.MyViewHolderTicket>{

        List<MyObject> list;
        private Context context;

    public class MyViewHolderTicket extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textViewView;
        private CardView cardView;
        private ImageView imageView;

        //itemView est la vue correspondante à 1 cellule
        public MyViewHolderTicket(View itemView) {
            super(itemView);

            //c'est ici que l'on fait nos findView
            imageView = (ImageView) itemView.findViewById(R.id.image);
            cardView = (CardView) itemView.findViewById(R.id.myticketcard);
            textViewView = (TextView) itemView.findViewById(R.id.text);

            //C'est ici qu'on permet l'écoute des items
            itemView.setOnClickListener(this);
        }

        //puis ajouter une fonction pour remplir la cellule en fonction d'un MyObject
        public void bind(MyObject myObject){
            textViewView.setText(myObject.getText());
            imageView.setImageResource(myObject.getImageUrl());
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            } );
        }

        public void onClick(View v) {

            //itemClickListener.onClick(v,getAdapterPosition(),false);
        }
    }

    //ajouter un constructeur prenant en entrée une liste
    public MyAdapterTicket(List<MyObject> list, Context context) {
        this.context=context;
        this.list = list;
    }

    //cette fonction permet de créer les viewHolder
    //et par la même indiquer la vue à inflater (à partir des layout xml)
    @Override
    public MyViewHolderTicket onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_card_ticket,viewGroup,false);
        return new MyViewHolderTicket(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolderTicket myViewHolder, int position) {
        MyObject myObject = list.get(position);
        myViewHolder.bind(myObject);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
