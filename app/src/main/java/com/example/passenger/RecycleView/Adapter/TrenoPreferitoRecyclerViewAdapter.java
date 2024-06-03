package com.example.passenger.RecycleView.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.passenger.R;
import com.example.passenger.RecycleView.Models.Treno;

import java.util.ArrayList;

public class TrenoPreferitoRecyclerViewAdapter extends RecyclerView.Adapter<TrenoPreferitoRecyclerViewAdapter.ViewHolder> {
    public TrenoPreferitoRecyclerViewAdapter(Context context) {
        this.context = context;
    }
    public ArrayList<Treno> getTreniPreferiti() {
        return treniPreferiti;
    }
    private Context context;
    private ArrayList<Treno> treniPreferiti = new ArrayList<>();
    @NonNull
    @Override
    public TrenoPreferitoRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.treni_preferiti_list, parent, false);
        return new TrenoPreferitoRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrenoPreferitoRecyclerViewAdapter.ViewHolder holder, int position) {
        Treno treno = treniPreferiti.get(position);
        holder.textView_numeroTreno.setText(treno.getNumeroTreno());
        holder.textView_stazionePartenza.setText(treno.getPartenza());
        holder.textView_orarioPartenza.setText(treno.getOrarioPartenza().toString());
        holder.textView_stazioneArrivo.setText(treno.getArrivo());
        holder.textView_orarioArrivo.setText(treno.getOrarioArrivo().toString());
    }
    public void setTreniPreferiti(ArrayList<Treno> treniPreferiti) {
        this.treniPreferiti = treniPreferiti;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return treniPreferiti.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView_treniPreferiti;
        TextView textView_numeroTreno;
        TextView textView_stazionePartenza;
        TextView textView_orarioPartenza;
        TextView textView_stazioneArrivo;
        TextView textView_orarioArrivo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView_treniPreferiti = itemView.findViewById(R.id.cardView_treniPreferiti);
            textView_numeroTreno = itemView.findViewById(R.id.textView_numeroTreno);
            textView_stazionePartenza = itemView.findViewById(R.id.textView_stazionePartenza);
            textView_orarioPartenza = itemView.findViewById(R.id.textView_orarioPartenza);
            textView_stazioneArrivo = itemView.findViewById(R.id.textView_stazioneArrivo);
            textView_orarioArrivo = itemView.findViewById(R.id.textView_orarioArrivo);
        }
    }
}
