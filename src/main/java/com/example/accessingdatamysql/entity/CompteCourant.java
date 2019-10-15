package com.example.accessingdatamysql.entity;

import javax.persistence.*;

/**
 * The type Compte courant.
 */
@Entity
public class CompteCourant extends Compte {

    private double montantDecouvertAutorise;

    /**
     * Instantiates a new Compte courant.
     */
    public CompteCourant() {

    }

    @Override
    public Operation debiter(double somme,String libelle) {
        if ( somme < 0) {
            throw new IllegalArgumentException("Pas de nombre négatif ! ");
        }else if(this.solde - somme <  - montantDecouvertAutorise ){
            throw new IllegalArgumentException("Débit trop important par rapport au découvert autorisé ");
        }
        this.solde -= somme;
        return new Operation(libelle,-somme);

    }

    /**
     * Instantiates a new Compte courant.
     *
     * @param intitule                 the intitule
     * @param solde                    the solde
     * @param montantDecouvertAutorise the montant decouvert autorise
     */
    public CompteCourant( String intitule, double solde, double montantDecouvertAutorise) {
        super( intitule, solde);
        this.montantDecouvertAutorise = montantDecouvertAutorise;
    }


    public double getMontantDecouvertAutorise() {
        return montantDecouvertAutorise;
    }

    public void setMontantDecouvertAutorise(double montantDecouvertAutorise) {
        this.montantDecouvertAutorise = montantDecouvertAutorise;
    }
}
