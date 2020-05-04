/**
 * Theodora Nguyen
 * Professor David-Guy Brizan
 * CS 245-01
 * 26 April 2020
 * */
import java.util.*;

public class Database {
    private HashMap<String, Product> Item;
    private HashMap<String, Service> Company;

    public Database(){
        this.Item = new HashMap<String, Product>();
        this.Company = new HashMap<String, Service>();

    }

    public void addProduct(String key, Product product, String service) {
        System.out.println("This is the incoming key"+ key);
        if (!this.Item.containsKey(key)) {
            System.out.println("IN IF");
            Item.put(key, product);
            //System.out.println("IN IF");

        }
        else {
//            this.Item.get(key).addService(service);
//            this.Item.get(key).addAmount(product.getAmount());
            System.out.println("IN ELSE");
            Item.put(key, product);
//            System.out.println("IN ELSE");
        }

        System.out.println("MAP ITEM (below)");
        System.out.println(Item.toString());
    }

    public void addService(String key, Service service){
        this.Company.put(key, service);
    }

    public Product getProduct(String item)
    {
        //System.out.println(item);
        return Item.get(item);
    }

    public boolean containsItem(String item) {
        System.out.println("containsItem " + this.Item.keySet().toString());
        return this.Item.containsKey(item);
    }

    public HashMap<String, Product> getItem() {

        return Item;
    }

    public HashMap<String, Service> getCompany() {

        return Company;
    }

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
        //ArrayList<String> services;
        //ArrayList<String> amounts;

        public Product(String description, String amount, String price, String service)
        {
            this.description = description;
            this.price = price;
            //services = new ArrayList<String>();
            //amounts = new ArrayList<String>();
            this.service = service;
            this.amount = amount;
            //addAmount(amount);
            //addService(service);
        }

//        public void addService(String service) {
//            this.services.add(service);
//        }
//
//        public  void addAmount(String amount)
//        {
//            this.amounts.add(amount);
//        }

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
        //String company;
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
//            if (Company.get(company).getCompany_file().contains(company)){
//                Company.remove(company);
//            }

            if (!company.equals(service_name))
            {
                Company.remove(company);
            }
        }

        System.out.println("Remove item set result \n" + Item.keySet());
        System.out.println(Company.keySet());
    }

}
