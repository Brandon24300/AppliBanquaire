package com.example.accessingdatamysql.entity;

import com.example.accessingdatamysql.interfacee.ICompteStat;
import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Compte.
 *
 */


@MappedSuperclass
 public abstract class Compte implements ICompteStat {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected Integer numero;
    protected String intitule;
    protected double solde;
    @ManyToOne
    @JsonManagedReference
    private Client client;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Operation> operationSet;

    private static int nbComptes;

    public Compte() {
        operationSet = new HashSet<>();
        nbComptes++;
    }


    protected Compte( String intitule, double solde) {
        this.intitule = intitule;
        this.solde = solde;
        operationSet = new HashSet<>();
        nbComptes++;
    }

    public void addOperation(Operation op){
        operationSet.add(op);
    }

    /**
     * Crediter.
     *
     * @param credit doit être un entier positif
     */
    public Operation crediter(double credit,String libelle) {

        if (credit < 0) {
            throw new IllegalArgumentException("Un credit ne peut pas être négatif!");
        }
        solde += credit;
        return new Operation(libelle,credit);
    }

    /**
     * Debiter double.
     *
     * @param somme doit être un entier positif
     *
     */
    public abstract Operation debiter(double somme,String libelle);

    @Override
    public String toString() {
        return "Compte{" +
                "numero='" + numero + '\'' +
                ", intitule='" + intitule + '\'' +
                ", solde=" + solde +
                '}';
    }

    public Set<Operation> getOperationSet() {
        return operationSet;
    }

    public void setOperationSet(Set<Operation> operationSet) {
        this.operationSet = operationSet;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Compte){
            Compte c = (Compte) obj;
            return c.getNumero() == this.getNumero();
        }
        return super.equals(obj);
    }
}
