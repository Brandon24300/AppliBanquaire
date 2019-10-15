package com.example.accessingdatamysql.controller;

import com.example.accessingdatamysql.entity.*;
import com.example.accessingdatamysql.repository.ClientRepository;
import com.example.accessingdatamysql.repository.CompteCourantRepository;
import com.example.accessingdatamysql.repository.CompteEpargneRepository;
import com.example.accessingdatamysql.repository.OperationRepository;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contient le compte courant controllet et compte epargne controller
 */
@Controller    // This means that this class is a Controller
@RequestMapping(path="/compte")
public class CompteController {

    @Autowired
    private CompteEpargneRepository compteEpargneRepository;

    @Autowired
    private CompteCourantRepository compteCourantRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OperationRepository operationRepository;

    /**
     * Gets all compte courant.
     *
     * @return the all compte courant
     */
    @GetMapping(path="/courant/all")
    public @ResponseBody
    Iterable<CompteCourant> getAllCompteCourant() {
        // This returns a JSON with the users
        return compteCourantRepository.findAll();
    }

    /**
     *
     * @param numero du compte courant
     *               Supprimes les opérations associés au compte
     * @return
     */
    @PostMapping(path="/courant/delete") // Map ONLY POST Requests
    public @ResponseBody String removeCompteCourantClient(@RequestParam Integer numero){
        List<Operation> allCompteCourant = operationRepository.findAllCompteCourantOperation(numero);
        allCompteCourant.forEach(x -> operationRepository.deleteById(x.getId()));
        compteCourantRepository.delete(compteCourantRepository.findById(numero).get());
        return "Deleted";
    }

    /**
     * Add new compte courant string.
     *
     * @param intitule                 the intitule
     * @param solde                    the solde
     * @param montantDecouvertAutorise the montant decouvert autorise
     * @return the string
     */
    @PostMapping(path="/courant/add") // Map ONLY POST Requests
    public @ResponseBody String addNewCompteCourant (
             @RequestParam String intitule, @RequestParam double solde, @RequestParam double montantDecouvertAutorise, int numClient) {
        CompteCourant n = new CompteCourant();
        n.setIntitule(intitule);
        n.setSolde(solde);
        n.setMontantDecouvertAutorise(montantDecouvertAutorise);
        n.setClient( clientRepository.findById(numClient).get());
        compteCourantRepository.save(n);

        return "Saved";
    }
// ===========================================EPARGNEEEEEEEEEEEEEEEE ========================================================


    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<CompteEpargne> getAllCompteEpargne() {
        // This returns a JSON with the users
        return compteEpargneRepository.findAll();
    }

    /**
     *
     * @param numero du compte d'epargne
     *               Delete aussi les operations associés
     * @return
     */
    @PostMapping(path="/epargne/delete") // Map ONLY POST Requests
    public @ResponseBody String removeCompteEpargneClient(@RequestParam Integer numero){
        List<Operation> allCompteEpargne = operationRepository.findAllCompteEpargneOperation(numero);
        allCompteEpargne.forEach(x -> operationRepository.deleteById(x.getId()));
        compteEpargneRepository.delete(compteEpargneRepository.findById(numero).get());
        return "Deleted";
    }

    @PostMapping(path="/epargne/add") // Map ONLY POST Requests
    public @ResponseBody String addNewCompteEpargne (
            @RequestParam String intitule, @RequestParam double solde, @RequestParam double tauxInteret, int numClient) {
        CompteEpargne n = new CompteEpargne(intitule,solde,tauxInteret);
        n.setClient( clientRepository.findById(numClient).get());
        compteEpargneRepository.save(n);

        return "Saved";
    }



}
