package com.agitex.climax.web.dao;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.agitex.climax.web.model.Client;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;


public class ClientDaoJSON {

    public ArrayList<Client> readJson()
    {
        ArrayList<Client> clients = new ArrayList<Client>();
        ObjectMapper obj =new ObjectMapper();
        try {
            JsonNode jsonNode = obj.readTree(new File("clients.json"));
            
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
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
