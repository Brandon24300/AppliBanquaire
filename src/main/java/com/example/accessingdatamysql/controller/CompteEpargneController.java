package com.example.accessingdatamysql.controller;

import com.example.accessingdatamysql.entity.CompteCourant;
import com.example.accessingdatamysql.entity.CompteEpargne;
import com.example.accessingdatamysql.repository.CompteCourantRepository;
import com.example.accessingdatamysql.repository.CompteEpargneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/compteEpargne")
public class CompteEpargneController {
    @Autowired
    private CompteEpargneRepository compteEpargneRepository;

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<CompteEpargne> getAllCompteEpargne() {
        // This returns a JSON with the users
        return compteEpargneRepository.findAll();
    }

}
