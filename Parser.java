/**
 * Theodora Nguyen
 * Professor David-Guy Brizan
 * CS 245-01
 * 26 April 2020
 * */

import java.io.*;
import java.util.*;

public class Parser {

    public void cvsparser(String inputFile, Database storeDatabase, String service) { //Razan, look at this, specifically the function name
        String line = null; //maybe change this to null?

        try {
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferReader = new BufferedReader(fileReader); //appends to buffer after input is read //CHECK THIS
            int linecounter =0;
            while ((line = bufferReader.readLine()) != null) {
                System.out.println(line);
                System.out.println(linecounter);
                System.out.println(inputFile);
                String[] tokenized_line = Parser.parserLine(line, ", ");
                System.out.println(Arrays.toString(tokenized_line));
                Database.Product product = storeDatabase.new Product(tokenized_line[1],tokenized_line[2], tokenized_line[3], service);
                System.out.println(product.toString());
                storeDatabase.addProduct(tokenized_line[0], product, service);
                linecounter ++;

            }

        } catch (FileNotFoundException e)
        {
            System.out.println("FILE NOT FOUND");
            return;
        } catch (IOException f)
        {
            System.out.println("line reading failed");
            return;
        }
    }

    public void configparser(String inputFile, Database storeDatabase) { //this is text
        String line = null; //maybe change this to null?

        try {
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferReader = new BufferedReader(fileReader); //appends to buffer after input is read //CHECK THIS
             while ((line = bufferReader.readLine()) != null) {
                 //System.out.println("Line: " + line);
                 String[] tokenized_line = Parser.parserLine(line, "[,=]");
                 //System.out.println("Got here: " + tokenized_line.length);
                 Database.Service service = storeDatabase.new Service(tokenized_line[2], tokenized_line[3]);
                 //System.out.println(service.toString());
                 storeDatabase.addService(tokenized_line[1], service);
                 //System.out.println("END OF LINE\n\n");
             }
             HashMap temp = storeDatabase.getCompany();
            for (String entry : storeDatabase.getCompany().keySet()) {
                System.out.println("LOOPING TYHROUGH HASHAMPA");
                System.out.println(entry);
                System.out.println(entry);
                Database.Service value = (Database.Service) temp.get(entry);
                System.out.println(temp.get(entry));
                System.out.println(value);
                System.out.println(value.getCompany_file());
                this.cvsparser(value.getCompany_file(), storeDatabase, entry);
            }

//            temp = storeDatabase.getItem();
//            for (String entry : storeDatabase.getItem().keySet()) {
//                Database.Product value = (Database.Product) temp.get(entry);
//                System.out.println(entry + ":" + value.toString());
//            }

        }
        catch (FileNotFoundException e)
        {
            System.out.println("FILE NOT FOUND");
            return;
        }
        catch (IOException f)
        {
            System.out.println("line reading failed");
            return;
        }
    }

    public static String[] parserLine(String line, String regex)
    {
        String[] items = line.split(regex);

        for (int i = 0; i < items.length; i++)
        {
            items[i] = items[i].toLowerCase();
            System.out.println(items[i]);
        }
        return items;
    }
}
