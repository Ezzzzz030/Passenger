package com.example.passenger.RecycleView.Models;

import java.sql.Time;

public class Treno {

    public Treno(String numeroTreno, String partenza, String arrivo, Time orarioPartenza, Time orarioArrivo) {
        NumeroTreno = numeroTreno;
        Partenza = partenza;
        Arrivo = arrivo;
        OrarioPartenza = orarioPartenza;
        OrarioArrivo = orarioArrivo;
    }
    private String NumeroTreno;
    private String Partenza;
    private String Arrivo;
    private Time OrarioPartenza;
    private Time OrarioArrivo;

    public String getPartenza() {
        return Partenza;
    }

    public void setPartenza(String partenza) {
        Partenza = partenza;
    }

    public String getArrivo() {
        return Arrivo;
    }

    public void setArrivo(String arrivo) {
        Arrivo = arrivo;
    }

    public Time getOrarioPartenza() {
        return OrarioPartenza;
    }

    public void setOrarioPartenza(Time orarioPartenza) {
        OrarioPartenza = orarioPartenza;
    }

    public Time getOrarioArrivo() {
        return OrarioArrivo;
    }

    public void setOrarioArrivo(Time orarioArrivo) {
        OrarioArrivo = orarioArrivo;
    }
    public String getNumeroTreno() {
        return NumeroTreno;
    }
    public void setNumeroTreno(String numeroTreno) {
        NumeroTreno = numeroTreno;
    }
}
