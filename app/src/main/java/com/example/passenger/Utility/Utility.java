package com.example.passenger.Utility;

import com.example.passenger.RecycleView.Models.Stazione;

import java.util.ArrayList;
import java.util.Collection;

public class Utility {
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
}
