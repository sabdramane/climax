package com.agitex.climax.web.controller;


import java.util.ArrayList;

import com.agitex.climax.web.dao.ClientDaoCSV;
import com.agitex.climax.web.model.Client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CSVController {
    
    @GetMapping(value =  "/donnees-csv")
    public String index(Model model)
    {
        ClientDaoCSV clientDaoCSV = new ClientDaoCSV();
        ArrayList<Client> clients = clientDaoCSV.readCSV();
        model.addAttribute("clients", clients);
        return "clients-csv/index";
    }

    @GetMapping(value =  "csv/calcul-moyenne")
    public String afficheFormulaireCalcul(Model model)
    {
        Client client = new Client();
        ClientDaoCSV clientDaoCSV = new ClientDaoCSV();
        ArrayList<String> professions = clientDaoCSV.listeProfession();
        model.addAttribute("professions", professions);
        model.addAttribute("client", client);
        return "clients-csv/formulaireCalcul";
    }

    @PostMapping(value =  "csv/calcul-moyenne")
    public String afficheMoyenneSalaire(@ModelAttribute("client") Client client,Model model)
    {
        ClientDaoCSV clientDaoCSV = new ClientDaoCSV();
        double moyenne = clientDaoCSV.calculMoyenne(client.getProfession());

        model.addAttribute("moyenne", moyenne);
        model.addAttribute("profession", client.getProfession());
        return "clients-csv/moyenne";
    }

    @GetMapping(value =  "csv/nouveau-client")
    public String create(Model model)
    {
        Client client = new Client();
        ClientDaoCSV clientDaoCSV = new ClientDaoCSV();
        ArrayList<String> professions = clientDaoCSV.listeProfession();
        model.addAttribute("professions", professions);
        model.addAttribute("client", client);
        return "clients-csv/form-create";
    }
    @PostMapping(value =  "csv/nouveau-client")
    public String store(@ModelAttribute("client") Client client,Model model)
    {
        ClientDaoCSV clientDaoCSV = new ClientDaoCSV();
        clientDaoCSV.saveCSV(client);
        return "redirect:/donnees-csv";
    }
}
