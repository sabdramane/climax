package com.agitex.climax.web.controller;

import java.util.ArrayList;

import com.agitex.climax.web.dao.ClientDaoXML;
import com.agitex.climax.web.model.Client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class XMLController {
    
    @GetMapping(value =  "/donnees-xml")
    public String index(Model model)
    {
        ClientDaoXML clientDaoXML = new ClientDaoXML();
        ArrayList<Client> clients = clientDaoXML.readXML();
        model.addAttribute("clients", clients);
        return "clients-xml/index";
    }

    @GetMapping(value =  "xml/calcul-moyenne")
    public String afficheFormulaireCalcul(Model model)
    {
        Client client = new Client();
        ClientDaoXML clientDaoXML = new ClientDaoXML();
        ArrayList<String> professions = clientDaoXML.listeProfession();
        model.addAttribute("professions", professions);
        model.addAttribute("client", client);
        return "clients-xml/formulaireCalcul";
    }

    @PostMapping(value =  "xml/calcul-moyenne")
    public String afficheMoyenneSalaire(@ModelAttribute("client") Client client,Model model)
    {
        ClientDaoXML clientDaoXML = new ClientDaoXML();
        double moyenne = clientDaoXML.calculMoyenne(client.getProfession());

        model.addAttribute("moyenne", moyenne);
        model.addAttribute("profession", client.getProfession());
        return "clients-xml/moyenne";
    }

    @GetMapping(value =  "xml/nouveau-client")
    public String create(Model model)
    {
        Client client = new Client();
        ClientDaoXML clientDaoXML = new ClientDaoXML();
        ArrayList<String> professions = clientDaoXML.listeProfession();
        model.addAttribute("professions", professions);
        model.addAttribute("client", client);
        return "clients-xml/form-create";
    }
    @PostMapping(value =  "xml/nouveau-client")
    public String store(@ModelAttribute("client") Client client,Model model)
    {
        ClientDaoXML clientDaoXML = new ClientDaoXML();
        clientDaoXML.saveXML(client);
        return "redirect:/donnees-xml";
    }
}
