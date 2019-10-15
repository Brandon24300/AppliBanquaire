package com.example.accessingdatamysql.entity;

import com.example.accessingdatamysql.interfacee.ICompteStat;

import java.util.List;

public class StatMachine implements ICompteStat {
    private List<Compte> compteList;

    public StatMachine(List<Compte> compteList) {
        this.compteList = compteList;
    }

    @Override
    public double getSolde() {

        return this.compteList.stream()
                .mapToDouble(x -> x.getSolde()).average().getAsDouble();
    }
}
