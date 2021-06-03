package com.agitex.climax.web.dao;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.agitex.climax.web.model.Client;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ClientDaoCSV {

    public void saveCSV(Client client)
    {
        
        try {
            FileWriter fileWriter = new FileWriter("clients.csv",true);
            CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.RFC4180);
            // csvPrinter.println();
            csvPrinter.printRecord(client.getNom(),client.getPrenom(),client.getAge(),
                                    client.getProfession(),client.getSalaire());
            csvPrinter.flush();
            csvPrinter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ArrayList<Client> readCSV()
    {
        ArrayList<Client> clients = new ArrayList<Client>();

            Resource resource = new ClassPathResource("/clients.csv");
            InputStream is;
            try {
                is = resource.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                // Reader csvData = new FileReader("/clients.csv");

                CSVParser parser = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(br);
               
                for(CSVRecord csvRecord : parser)
                {
                    String nom = csvRecord.get("nom");
                    String prenom = csvRecord.get("prenom");
                    int age = Integer.valueOf(csvRecord.get("age"));
                    String profession = csvRecord.get("profession");
                    int salaire = Integer.valueOf(csvRecord.get("salaire"));

                    Client client = new Client(nom,prenom,age,profession,salaire);
                    clients.add(client);
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
       ArrayList<Client> clients = readCSV();

        for (Client client : clients) {
            professions.add(client.getProfession());
        }

        Set<String> mySet = new HashSet<String>(professions);
        professions = new ArrayList<String>(mySet);
        return professions;
    }

    public double calculMoyenne(String profession)
    {
        ArrayList<Client> clients = readCSV();
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
