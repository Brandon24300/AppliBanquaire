package com.example.accessingdatamysql.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    private String prenom;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonBackReference
    private Set<CompteEpargne> compteEpargne;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonBackReference
    private Set<CompteCourant> compteCourant;

    public Client(){
        compteEpargne = new HashSet<>();
        compteCourant = new HashSet<>();
    }

    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        compteEpargne = new HashSet<>();
        compteCourant = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public Set<CompteEpargne> getCompteEpargne() {
        return compteEpargne;
    }

    public void setCompteEpargne(Set<CompteEpargne> compteEpargne) {
        this.compteEpargne = compteEpargne;
    }

    public void addCompteCourant(CompteCourant compteCourant){
        getCompteCourant().add(compteCourant);
    }

    public Set<CompteCourant> getCompteCourant() {
        return compteCourant;
    }

    public void setCompteCourant(Set<CompteCourant> compteCourant) {
        this.compteCourant = compteCourant;
    }

    public double calculAvoir(){
        double somme = 0;
        if (compteCourant != null){
            for (Compte compte: compteCourant) {
                somme += compte.getSolde();
            }
        }

        if (compteEpargne != null){
            for (Compte compte: compteEpargne) {
                somme += compte.getSolde();
            }
        }
        return somme;
    }
}
