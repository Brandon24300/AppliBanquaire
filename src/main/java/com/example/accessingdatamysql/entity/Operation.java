package com.example.accessingdatamysql.entity;

import javax.persistence.*;

@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String libelle;
    private double somme;
    @ManyToOne
    private CompteCourant compteCourant;

    @ManyToOne
    private CompteEpargne compteEpargne;


    public Operation(String libelle, double somme) {
        this.libelle = libelle;
        this.somme = somme;
    }

    public Operation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getSomme() {
        return somme;
    }

    public void setSomme(double somme) {
        this.somme = somme;
    }

    public Compte getCompteCourant() {
        return compteCourant;
    }

    public void setCompteCourant(CompteCourant compteCourant) {
        this.compteCourant = compteCourant;
    }

    public CompteEpargne getCompteEpargne() {
        return compteEpargne;
    }

    public void setCompteEpargne(CompteEpargne compteEpargne) {
        this.compteEpargne = compteEpargne;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", somme=" + somme +
                ", compte=" + compteCourant +
                '}';
    }
}
