package com.agitex.climax.web.dao;

import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.agitex.climax.web.model.Client;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class ClientDaoJSON {

    public ArrayList<Client> readJson()
    {
        ArrayList<Client> clients = new ArrayList<Client>();
        ObjectMapper obj =new ObjectMapper();

        Resource resource = new ClassPathResource("/clients.json");
        InputStream is;

        try {
                is = resource.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                JsonNode jsonNode = obj.readTree(br);
                
                Iterator<JsonNode> elements= jsonNode.get("client").elements();

                while(elements.hasNext())
                {
                    JsonNode jsonNode2 = elements.next();
                    String  nom = jsonNode2.get("nom").asText();
                    String prenom = jsonNode2.get("prenom").asText();
                    int age = jsonNode2.get("age").asInt();
                    String profession = jsonNode2.get("profession").asText();
                    int salaire = jsonNode2.get("salaire").asInt();;
        
                    Client client = new Client(nom,prenom,age,profession,salaire);
                    clients.add(client);
                    // age =age+" " +" "+ jsonNode2.get("age").asInt();
                    // prenom =prenom+" " +" "+ jsonNode2.get("prenom").asText();
                    // nom =nom+" " +" "+ jsonNode2.get("nom").asText();
                }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
            
        

      return clients;
    }

    public ArrayList<String> listeProfession()
    {
       ArrayList<String> professions = new ArrayList<String>();
       ArrayList<Client> clients = readJson();

        for (Client client : clients) {
            professions.add(client.getProfession());
        }

        Set<String> mySet = new HashSet<String>(professions);
        professions = new ArrayList<String>(mySet);
        return professions;
    }

    public double calculMoyenne(String profession)
    {
        ArrayList<Client> clients = readJson();
        double sommeSalaire = 0;
        int nbCLient = 0;
        for (Client client : clients) {
           if(client.getProfession().equals(profession))
           {
               nbCLient = nbCLient+1;
                sommeSalaire= sommeSalaire + client.getSalaire();
           }
        }
        double moyenne = sommeSalaire/nbCLient;
        return moyenne;
    }

    
}
