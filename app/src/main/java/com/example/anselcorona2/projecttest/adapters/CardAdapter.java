package com.example.anselcorona2.projecttest.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.anselcorona2.projecttest.R;
import com.example.anselcorona2.projecttest.entities.Card;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Card> cards;
    private OnCardClickListener onCardClickListener;

    public interface OnCardClickListener{
        void onCardClick(Card card);
    }

    public void setOnCardClickListener(OnCardClickListener onCardClickListener){
        this.onCardClickListener = onCardClickListener;
    }

    public CardAdapter(Context context, ArrayList<Card> cards){
        this.context = context;
        this.cards = cards;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Card card = cards.get(position);
        holder.CardBody.setText(card.getBody());
        holder.CardDate.setText(card.getFecha().toString());
        holder.CardTipo.setText(card.getTipo());
        holder.CardNivel.setText(card.getNivel());
        holder.CardNivel.setTypeface(null, Typeface.BOLD);

        switch (card.getNivel()){
            case "Nacional":
                holder.CardBanner.setBackgroundColor(ContextCompat.getColor(context,R.color.DiscordLightBlack));
                break;
            case "Provincial":
                holder.CardBanner.setBackgroundColor(ContextCompat.getColor(context,R.color.DiscordDarkGrey));
                break;
            case "Municipal":
                holder.CardBanner.setBackgroundColor(ContextCompat.getColor(context,R.color.DiscordGrey));
                break;
            case "Regional":
                holder.CardBanner.setBackgroundColor(ContextCompat.getColor(context,R.color.DiscordWhite));
                break;
        }

        switch (card.getTipo()){
            case "Asignación":
                holder.CardInfo.setBackgroundColor(ContextCompat.getColor(context,R.color.GoogleYellow));
                break;
            case "Encuesta":
                holder.CardInfo.setBackgroundColor(ContextCompat.getColor(context,R.color.GoogleBlue));
                break;
            case "Mensaje":
                holder.CardInfo.setBackgroundColor(ContextCompat.getColor(context,R.color.GoogleGreen));
                break;
            case "Noticias":
                holder.CardInfo.setBackgroundColor(ContextCompat.getColor(context,R.color.GoogleRed));
                break;
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCardClickListener.onCardClick(card);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView CardTipo;
        TextView CardNivel;
        TextView CardDate;
        TextView CardBody;
        CardView Card;
        View CardBanner;
        LinearLayout CardInfo;

        ViewHolder(View itemView){
            super(itemView);
            Card = itemView.findViewById(R.id.card_list_item_card);
            CardTipo = itemView.findViewById(R.id.card_list_item_tipo);
            CardNivel = itemView.findViewById(R.id.card_list_item_nivel);
            CardDate = itemView.findViewById(R.id.card_list_item_date);
            CardBody = itemView.findViewById(R.id.card_list_item_body);
            CardBanner = itemView.findViewById(R.id.card_list_item_banner);
            CardInfo = itemView.findViewById(R.id.card_list_item_info);
        }
    }
}
