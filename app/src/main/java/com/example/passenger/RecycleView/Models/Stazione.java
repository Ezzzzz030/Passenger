package com.example.passenger.RecycleView.Models;

public class Stazione {

    private int Id;
    private String Nome;
    private String Indirizzo;

    public Stazione(int Id, String Nome, String Indirizzo) {
        this.Id = Id;
        this.Nome = Nome;
        this.Indirizzo = Indirizzo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getIndirizzo() {
        return Indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        Indirizzo = indirizzo;
    }
}
