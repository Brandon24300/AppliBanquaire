package com.example.accessingdatamysql.controller;

import com.example.accessingdatamysql.entity.*;
import com.example.accessingdatamysql.repository.CompteCourantRepository;
import com.example.accessingdatamysql.repository.CompteEpargneRepository;
import com.example.accessingdatamysql.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/operation")
public class OperationController {
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CompteCourantRepository compteCourantRepository;
    @Autowired
    private CompteEpargneRepository compteEpargneRepository;


    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<Operation> getAllOperation() {
        return operationRepository.findAll();
    }

    /**
     *
     * @param numeroCompte
     * @param somme
     * @param libelle
     * @param typeOperation 0 = crediter / 1 = debiter
     * @param typeCompte  0 = compte courant / 1 = compte epargne
     * @return
     */
    @PostMapping(path="/add")
    public @ResponseBody String ajoutOperationCompteCourant(@RequestParam Integer numeroCompte,@RequestParam double somme,
                                                @RequestParam String libelle,@RequestParam String typeOperation,@RequestParam String typeCompte) {
        if (!typeOperation.equalsIgnoreCase("crediter")  && !typeOperation.equalsIgnoreCase("debiter") ){
            throw new IllegalArgumentException("Le type de compte choisi n'est pas valide ! il doit être de 0 ou de 1");
        }
        Operation operation;
        if (typeCompte.equalsIgnoreCase("courant") ){
            CompteCourant c1 = compteCourantRepository.findById(numeroCompte).get();
            operation = typeOperation == "crediter" ? c1.crediter(somme,libelle) : c1.debiter(somme, libelle);
            operation.setCompteCourant(c1);
            operationRepository.save(operation) ;
        }else if(typeCompte.equalsIgnoreCase("epargne")){
            CompteEpargne c2 = compteEpargneRepository.findById(numeroCompte).get();
            operation = typeOperation == "crediter" ? c2.crediter(somme,libelle) : c2.debiter(somme, libelle);
            operation.setCompteEpargne(c2);
            operationRepository.save(operation) ;
        }

        return "Saved ! ";
    }

}
