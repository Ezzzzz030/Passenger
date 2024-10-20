package com.example.passenger.Utility;

import android.content.Context;
import android.net.ConnectivityManager;

import android.net.ConnectivityManager;
import com.example.passenger.RecycleView.Models.Stazione;
import com.example.passenger.RecycleView.Models.Treno;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;

public class Utility {
    public static boolean isNetworkConnected(Context ctx) {
        if ( ctx == null ) return true;
        ConnectivityManager cm = (ConnectivityManager)ctx.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
    public static ArrayList<Stazione> getFakeStazioni()
    {
        ArrayList<Stazione> stazioni = new ArrayList<>();
        stazioni.add(new Stazione(1, "Chiasso", "6830 Chiasso, Svizzera"));
        stazioni.add(new Stazione(2, "Como San Giovanni", "P.le S. Gottardo, 22100 Como CO"));
        stazioni.add(new Stazione(3, "Como Camerlata", "22100 Como CO"));
        stazioni.add(new Stazione(4, "Cucciago", "22073 Fino Mornasco CO"));
        stazioni.add(new Stazione(5, "Cantù-Cermenate", "22063 Cantù Asnago CO"));

        return stazioni;
    }

    public static ArrayList<Treno> getFakeTreni()
    {
        ArrayList<Treno> treni = new ArrayList<>();
        treni.add(new Treno("24958","Como", "Chiasso",  new Time(6, 0, 0), new Time(7, 30, 0)));
        treni.add(new Treno("24958","Como", "Chiasso",  new Time(7, 30, 0), new Time(9, 0, 0)));
        treni.add(new Treno("24958","Como", "Chiasso",  new Time(9, 0, 0), new Time(10, 30, 0)));
        treni.add(new Treno("24958","Como", "Chiasso",  new Time(10, 30, 0), new Time(12, 0, 0)));
        treni.add(new Treno("24958","Como", "Chiasso",  new Time(6, 0, 0), new Time(7, 30, 0)));
        treni.add(new Treno("24958","Como", "Chiasso",  new Time(7, 30, 0), new Time(9, 0, 0)));
        treni.add(new Treno("24958","Como", "Chiasso",  new Time(9, 0, 0), new Time(10, 30, 0)));
        treni.add(new Treno("24958","Como", "Chiasso",  new Time(10, 30, 0), new Time(12, 0, 0)));
        return treni;
    }
}
