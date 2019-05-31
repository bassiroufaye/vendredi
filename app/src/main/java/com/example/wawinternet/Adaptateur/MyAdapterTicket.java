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

import com.example.wawinternet.MesMessages.ServiceCommerciale;
import com.example.wawinternet.MesMessages.ServiceTechnique;
import com.example.wawinternet.MesMessages.WawIncident;
import com.example.wawinternet.MesMessages.WawPayment;
import com.example.wawinternet.MesMessages.WawPromo;
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

            textViewView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position= getAdapterPosition();
                    if(position==0){
                        Intent intent0=new Intent(context, ServiceTechnique.class);
                        context.startActivity(intent0);
                    }
                    else{
                        if (position==1){
                            Intent intent1=new Intent(context, ServiceCommerciale.class);
                            context.startActivity(intent1);
                        }
                        else {
                            if(position==2){
                                Intent intent2=new Intent(context, WawPromo.class);
                                context.startActivity(intent2);
                            }
                            else{
                                if(position==3){
                                    Intent intent3=new Intent(context, WawPayment.class);
                                    context.startActivity(intent3);
                                }
                                else{
                                    Intent intent4=new Intent(context, WawIncident.class);
                                    context.startActivity(intent4);
                                }
                            }
                        }
                    }
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
