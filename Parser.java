/**
 * Theodora Nguyen
 * Professor David-Guy Brizan
 * CS 245-01
 * 4 May 2020
 *
 *  @file
 *  Parses through the config file and the csv files.
 * */

import java.io.*;
import java.util.*;

public class Parser {

    public void cvsparser(String inputFile, Database storeDatabase, String service) { //Razan, look at this, specifically the function name
        String line = null;

        try {
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferReader = new BufferedReader(fileReader); //appends to buffer after input is read
            int linecounter = 0;
            while ((line = bufferReader.readLine()) != null) {
                String[] tokenized_line = Parser.parserLine(line, ", ");
                Database.Product product = storeDatabase.new Product(tokenized_line[1],tokenized_line[2], tokenized_line[3], service);
                storeDatabase.addProduct(tokenized_line[0], product);
                linecounter ++;
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("FILE NOT FOUND");
            return;
        } catch (IOException f)
        {
            System.out.println("UNABLE TO READ LINE");
            return;
        }
    }

    public void configparser(String inputFile, Database storeDatabase) { //this is text
        String line = null;

        try {
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferReader = new BufferedReader(fileReader); //appends to buffer after input is read
             while ((line = bufferReader.readLine()) != null) {
                 String[] tokenized_line = Parser.parserLine(line, "[,=]");
                 Database.Service service = storeDatabase.new Service(tokenized_line[2], tokenized_line[3]);
                 storeDatabase.addService(tokenized_line[1], service);
             }
             HashMap temp = storeDatabase.getCompany();
            for (String entry : storeDatabase.getCompany().keySet()) {
                Database.Service value = (Database.Service) temp.get(entry);
                this.cvsparser(value.getCompany_file(), storeDatabase, entry);
            }

        }
        catch (FileNotFoundException e)
        {
            System.out.println("FILE NOT FOUND");
            return;
        }
        catch (IOException f)
        {
            System.out.println("FAILED TO READ LINE");
            return;
        }
    }

    public static String[] parserLine(String line, String regex)
    {
        String[] items = line.split(regex);

        for (int i = 0; i < items.length; i++)
        {
            items[i] = items[i].toLowerCase();
        }
        return items;
    }
}
