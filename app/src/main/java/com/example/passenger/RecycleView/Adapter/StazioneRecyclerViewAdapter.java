package com.example.passenger.RecycleView.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.passenger.R;
import com.example.passenger.RecycleView.Models.Stazione;

import java.util.ArrayList;

public class StazioneRecyclerViewAdapter extends RecyclerView.Adapter<StazioneRecyclerViewAdapter.ViewHolder> {
    private ArrayList<Stazione> stazioni = new ArrayList<>();
    private Context context;
    public StazioneRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public StazioneRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stazione_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StazioneRecyclerViewAdapter.ViewHolder holder, int position) {
        Stazione stazione = stazioni.get(position);
        holder.textView_nomeStazione.setText(stazione.getNome());
        holder.textView_indirizzoStazione.setText(stazione.getIndirizzo());
        holder.imageView_imgStazione.setImageResource(R.drawable.baseline_location_on_24);
    }

    @Override
    public int getItemCount() {
        return stazioni.size();
    }

    public void setStazione(ArrayList<Stazione> stazioni){
        this.stazioni = stazioni;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView_treno;
        TextView textView_nomeStazione;
        TextView textView_indirizzoStazione;
        ImageView imageView_imgStazione;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView_treno = itemView.findViewById(R.id.cardView_treno);
            textView_nomeStazione = itemView.findViewById(R.id.textView_nomeStazione);
            textView_indirizzoStazione = itemView.findViewById(R.id.textView_indirizzoStazione);
            imageView_imgStazione = itemView.findViewById(R.id.imageView_imgStazione);
        }
    }
}
