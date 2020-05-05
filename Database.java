/**
 * Theodora Nguyen
 * Professor David-Guy Brizan
 * CS 245-01
 * 4 May 2020
 *
 * @file
 * Uses the implementation of a hashmap to create keys and values. The Item hashmap stores the name of the product as
 * the key and the description, size, and price as the value. The Service hashmap stores the service's name as the
 * key and the service's csv file and the price of the service's delivery fee as the value.
 * */
import java.util.*;

public class Database {
    private HashMap<String, Product> Item;
    private HashMap<String, Service> Company;

    public Database(){
        this.Item = new HashMap<String, Product>();
        this.Company = new HashMap<String, Service>();

    }

    /**
     * Adding a product name as key to the Product map.
     * */
    public void addProduct(String key, Product product) {
        if (!this.Item.containsKey(key)) {
            Item.put(key, product);
        }
        else {
            Item.put(key, product);
        }
    }

    /**
     * Adding a service name as a key to the Company map.
     * */
    public void addService(String key, Service service){
        this.Company.put(key, service);
    }

    /**
     * Returns the value of the specified key.
     * */
    public Product getProduct(String item)
    {
        return Item.get(item);
    }

    /**
     * Checks if the key is in the hashmap.
     * */
    public boolean containsItem(String item) {
        return this.Item.containsKey(item);
    }

    /**
     * Returns the Item's hashmap
     * */
    public HashMap<String, Product> getItem() {
        return Item;
    }

    /**
     * Returns the Company's hashmap
     * */
    public HashMap<String, Service> getCompany() {
        return Company;
    }

    /**
     * Returns the value (service) in the Company hashmap
     * */
    public Service getCompany(String key)
    {
        if(!Company.containsKey(key))
        {
            return null;
        }
        return Company.get(key);
    }



    public class Product {
        String description;
        String amount;
        String price;
        String service;

        public Product(String description, String amount, String price, String service)
        {
            this.description = description;
            this.price = price;
            this.service = service;
            this.amount = amount;
        }


        public String getService() {

            return service;
        }

        public String getDescription() {

            return description;
        }

        public String getAmount() {

            return amount;
        }

        public String getPrice() {

            return price;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "description='" + description + '\'' +
                    ", amount='" + amount.toString() + '\'' +
                    ", price='" + price + '\'' +
                    ", service='" + service.toString() + '\'' +
                    '}';
        }
    }

    public class Service{
        String company_file;
        String service_fee;

        public Service(String company_file, String service_fee)
        {
            this.company_file = company_file;
            this.service_fee = service_fee;
        }

        public String getCompany_file() {

            return company_file;
        }

        public String getService_fee() {

            return service_fee;
        }

        @Override
        public String toString() {
            return "Service{" +
                    "company_file='" + company_file + '\'' +
                    ", service_fee='" + service_fee + '\'' +
                    '}';
        }
    }

    public void removeService(String service_name){
        for (String item: Item.keySet())
        {
            if (!Item.get(item).getService().equals(service_name))
            {
                Item.remove(item);

            }
        }

        for (String company: Company.keySet())
        {
            if (!company.equals(service_name))
            {
                Company.remove(company);
            }
        }
    }
}
