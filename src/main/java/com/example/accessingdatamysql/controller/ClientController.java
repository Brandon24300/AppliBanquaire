package com.example.accessingdatamysql.controller;

import com.example.accessingdatamysql.entity.Client;
import com.example.accessingdatamysql.entity.Compte;
import com.example.accessingdatamysql.entity.CompteCourant;
import com.example.accessingdatamysql.repository.ClientRepository;
import com.example.accessingdatamysql.repository.CompteCourantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping(path="/client")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CompteCourantRepository compteCourantRepository;


    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewClient (@RequestParam String nom
            , @RequestParam String prenom) {
        clientRepository.save(new Client(nom,prenom));
        return "Saved";
    }

    @PostMapping(path="/delete") // Map ONLY POST Requests
    public @ResponseBody String removeClient(@RequestParam Integer numClient){
        clientRepository.delete(clientRepository.findById(numClient).get());
        return "Deleted";
    }

    @GetMapping(path="/all") // Map ONLY POST Requests
    public @ResponseBody
    Iterable<Client> getAllCompteClient () {
        return clientRepository.findAll();
    }

}
