/**
 * Theodora Nguyen
 * Professor David-Guy Brizan
 * CS 245-01
 * 4 May 2020
 *
 *  @file
 *  The driver of the program.
 * */
import java.util.*;
import java.lang.Float;

public class ALaCarte{

    public static void main(String[] args)
    {
        Database d = new Database();
        Parser c = new Parser();

        c.configparser("config.txt", d);

        Scanner scanner = new Scanner(System.in);

        double serviceFee = 0;
        double total = 0;
        Database.Product product = null;

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

                for(String item : items.keySet())
                {
                    Database.Product p = items.get(item);

                    if(p.getDescription().equals(input_item))
                    {
                        input_item = item;
                        found = true;
                        break;
                    }
                }

                if(!found)
                {
                    System.out.println("Item was not found. Unable to fulfill your order. Please try again.");
                    continue;
                }
            }

            System.out.println("Size: ");
            String input_size = scanner.nextLine();

            product = d.getProduct(input_item);

            if(!product.amount.equals(input_size))
            {
                System.out.println("Item size was not found. Unable to fulfill your order. Please try again.");
                continue;
            }

            System.out.println("Quantity: ");
            String input_quantity = scanner.nextLine();

            Double quantity = Double.valueOf(input_quantity);
            Double roundQuantity = Math.floor(quantity);

            serviceFee = Double.valueOf(d.getCompany(product.getService()).getService_fee());

            total += quantity * Double.valueOf(product.getPrice().substring(1));

            //checks if the user's quantity is a fraction
            if((quantity % roundQuantity) != 0)
            {
                System.out.println("Item quantity was not found. Unable to fulfill your order. Please try again.");
                continue;
            }

            d.removeService(product.getService());
        }

        System.out.printf("Best price is through %s.\nFinal cost for items is $%.2f with service fee of $%.2f amounts to $%.2f", product.getService().toUpperCase(), total, serviceFee, total + serviceFee);
        total += serviceFee;
    }
}







