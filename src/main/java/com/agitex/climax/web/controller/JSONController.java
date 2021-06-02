package com.agitex.climax.web.controller;

import java.util.ArrayList;

import com.agitex.climax.web.dao.ClientDaoJSON;
import com.agitex.climax.web.dao.ClientDaoXML;
import com.agitex.climax.web.model.Client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JSONController {
    @GetMapping(value =  "/donnees-json")
    public String index(Model model)
    {
        ClientDaoJSON clientDaoJSON = new ClientDaoJSON();
        ArrayList<Client> clients = clientDaoJSON.readJson();
        model.addAttribute("clients", clients);
        return "clients-json/index";
    }

    @GetMapping(value =  "json/calcul-moyenne")
    public String afficheFormulaireCalcul(Model model)
    {
        Client client = new Client();
        ClientDaoJSON clientDaoJSON = new ClientDaoJSON();
        ArrayList<String> professions = clientDaoJSON.listeProfession();
        model.addAttribute("professions", professions);
        model.addAttribute("client", client);
        return "clients-json/formulaireCalcul";
    }

    @PostMapping(value =  "json/calcul-moyenne")
    public String afficheMoyenneSalaire(@ModelAttribute("client") Client client,Model model)
    {
        ClientDaoJSON clientDaoJSON = new ClientDaoJSON();
        double moyenne = clientDaoJSON.calculMoyenne(client.getProfession());

        model.addAttribute("moyenne", moyenne);
        model.addAttribute("profession", client.getProfession());
        return "clients-json/moyenne";
    }
}
