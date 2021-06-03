package com.agitex.climax.web.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.agitex.climax.web.model.Client;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ClientDaoXML {

    Element racine ;
    Document document ;

    public void saveXML(Client client)
    {
        SAXBuilder sxb = new SAXBuilder();
        try {
            document = sxb.build(new File("clients.xml"));
        } catch (JDOMException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        racine = document.getRootElement();
        
        Element clienteElement = new Element("client");
        racine.addContent(clienteElement);

        Element nom = new Element("nom");
        nom.setText(client.getNom());
        clienteElement.addContent(nom);

        Element prenom = new Element("prenom");
        prenom.setText(client.getPrenom());
        clienteElement.addContent(prenom);

        Element age = new Element("age");
        age.setText(""+client.getAge());
        clienteElement.addContent(age);

        Element profession = new Element("profession");
        profession.setText(client.getProfession());
        clienteElement.addContent(profession);

        Element salaire = new Element("salaire");
        salaire.setText(""+client.getSalaire());
        clienteElement.addContent(salaire);

        XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
        try {
            out.output(document, new FileOutputStream("clients.xml"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ArrayList<Client> readXML()
    {
        ArrayList<Client> clients = new ArrayList<Client>();
       
      SAXBuilder builder = new SAXBuilder();
      Resource resource = new ClassPathResource("/clients.xml");
        InputStream is;
        try {
            is = resource.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            try {
                Document  document = (Document) builder.build(br);
                Element rootNode = document.getRootElement();
                List<Element> list = rootNode.getChildren("client");
        
                for (int i = 0; i < list.size(); i++) {
                    Element node = (Element) list.get(i);

                String  nom = node.getChildText("nom");
                String prenom = node.getChildText("prenom");
                int age = Integer.valueOf(node.getChildText("age"));
                String profession = node.getChildText("profession");
                int salaire = Integer.valueOf(node.getChildText("salaire"));

                        Client client = new Client(nom,prenom,age,profession,salaire);
                        clients.add(client);
                }
            } catch (JDOMException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
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
       ArrayList<Client> clients = readXML();

        for (Client client : clients) {
            professions.add(client.getProfession());
        }

        Set<String> mySet = new HashSet<String>(professions);
        professions = new ArrayList<String>(mySet);
        return professions;
    }

    public double calculMoyenne(String profession)
    {
        ArrayList<Client> clients = readXML();
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
