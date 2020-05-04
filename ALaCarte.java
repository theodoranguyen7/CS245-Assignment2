/**
 * Theodora Nguyen
 * Professor David-Guy Brizan
 * CS 245-01
 * 26 April 2020
 * */
import java.util.*;
import java.lang.Float;

public class ALaCarte{

    public static void main(String[] args)
    {
        Database d = new Database();

        //ConfigParser.Parser("service=Instacart,instacart.csv,5.99\n");
        //System.out.println("Hello World!");
        Parser c = new Parser();
        c.configparser("config.txt", d);

        Scanner scanner = new Scanner(System.in);


        double serviceFee = 0;
        double total = 0;


        while (true) {
            System.out.println("Enter your next item or 'done': ");
            String input_item = scanner.nextLine().toLowerCase();

            if (input_item.equals("done"))
            {
                break;
            }
            else if (!d.containsItem(input_item))
            {
                boolean found = false;

                HashMap<String, Database.Product> items = d.getItem();
                //HashMap<String, Database.Service> service = d.getCompany();

                for(String item : items.keySet())
                {
                    Database.Product p = items.get(item);
                    if(p.getDescription().equals(input_item))
                    {
                        //int i = item.indexOf(item);
                        input_item = item;
                        found = true;
                        break;
                    }
                }
                if(!found)
                {
                    System.out.println("Item was not found. Unable to fulfill your order. Enter your next item or 'done': ");
                    continue;
                }
            }

            System.out.println("Size: ");
            String input_size = scanner.nextLine();

            Database.Product product = d.getProduct(input_item);
            System.out.println(product + input_size);
            if(!product.amount.equals(input_size))
            {
                //System.out.println(product + input_size);
                System.out.println("Item size was not found. Unable to fulfill your order. Enter your next item or 'done': ");
                continue;
            }

            System.out.println("Quantity: ");
            String input_quantity = scanner.nextLine();

            Double quantity = Double.valueOf(input_quantity);
            //System.out.println(quantity);
            Double roundQuantity = Math.floor(quantity);
            //System.out.println(roundQuantity);
            //do % stuff to get right thing

            serviceFee = Double.valueOf(d.getCompany(product.getService()).getService_fee());
            System.out.println(serviceFee);

            total += quantity * Double.valueOf(product.getPrice().substring(1));
            System.out.println(total);



            if((quantity % roundQuantity) != 0)
            {
                System.out.println("Item quantity was not found. Unable to fulfill your order. Enter your next item or 'done': ");
                continue;
            }

            d.removeService(product.getService());
        }

        System.out.printf("Final cost for items is $%.2f with service fee of $%.2f amounts to $%.2f", total, serviceFee, total + serviceFee);
        total += serviceFee;


    }
}







