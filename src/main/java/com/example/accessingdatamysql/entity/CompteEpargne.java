package com.example.accessingdatamysql.entity;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

@Entity
public class CompteEpargne extends  Compte {
    private double tauxInteret;

    public CompteEpargne( String intitule, double solde,double tauxInteret) {
        super( intitule, solde);
        this.tauxInteret = tauxInteret > 0 ? tauxInteret / 100 : -tauxInteret / 100;
    }


    @Override
    public Operation debiter(double somme,String libelle) {
        if ( somme < 0) {
            throw new IllegalArgumentException("Pas de nombre négatif ! ");
        }else if (somme > solde){
            throw new IllegalArgumentException("Débit supérieur au solde ");
        }
        this.solde -= somme;

        return new Operation(libelle,-somme);

    }

    public double calculInteret(){
        return tauxInteret == 0 ? 0 : solde * tauxInteret;
    }

    @Override
    public String toString() {
        return super.toString() + "CompteEpargne{" +
                "tauxInteret=" + tauxInteret +
                '}';
    }
}
