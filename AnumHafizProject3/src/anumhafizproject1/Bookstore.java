/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anumhafizproject1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * adds ArrayList for Books, CDs, DVDs, and members
 * @author Anum Hafiz
 */ 
public class Bookstore implements BookstoreSpecification {
    private ArrayList<Books> books = new ArrayList<Books>();
    private ArrayList<Cds> cds = new ArrayList<Cds>();
    private ArrayList<Dvds> dvds = new ArrayList<Dvds>();
    private static ArrayList<Person> members = new ArrayList<Person>();
    private ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<Product> dailyPurchaseList = new ArrayList<Product>();
    private static int newMembersRegistered = 0;
    private int numSales;
    private static int dayNum = 1;
    private double totalSales = 0;
    private int booksSoldToday =0;
    private int cdsSoldToday = 0;
    private int dvdsSoldToday = 0;
    
    /**
     * adds books, CDs, DVDs, into ArrayList for user to choose from
     * @param filename
     */
    public Bookstore(String filename) {
//        Books book1 = new Books("Divergent", "Veronica Roth", 8.99);
//        books.add(book1);
//        products.add(book1);
//        Books book2 = new Books("To Kill a Mockingbird", "Harper Lee", 9.99);
//        books.add(book2);
//        products.add(book2);
//        Cds cd1 = new Cds("Donda 2", "Kanye West", 19.99);
//        cds.add(cd1);
//        products.add(cd1);
//        Cds cd2 = new Cds("Hidden Gems", "AP Dhillon", 15.99);
//        cds.add(cd2);
//        products.add(cd2);
//        Dvds dvd1 = new Dvds("Inception", "Christopher Nolan", 7.99);
//        dvds.add(dvd1);
//        products.add(dvd1);
//        Dvds dvd2 = new Dvds("Jujutsu Kaisen 0", "Sunghoo Park", 12.99);
//        dvds.add(dvd2);
//        products.add(dvd2);
          newDay();
          generateInventory(filename);
    }

    /**
     *
     * @return
     */
    public ArrayList<Product> getProducts() {
        return products;
    }
    
    /**
     *
     * @return
     */
    public int getNumSales() {
        return numSales;
    }
    
    /**
     *
     * @param numPurchases
     */
    public void addSales(int numPurchases) {
        numSales += numPurchases;
    }
    
    private void newDay() {
        numSales = 0;
        dailyPurchaseList.clear();
        this.newMembersRegistered = 0;
        this.totalSales = 0;
        this.booksSoldToday =0;
        this.cdsSoldToday = 0;
        this.dvdsSoldToday = 0;
        
    }
    
    private void generateInventory(String filename) {
        File inventoryFile = new File(filename);
        Scanner scnr;
        
        try {
        scnr = new Scanner(inventoryFile);
        scnr.nextLine();
        
            while(scnr.hasNext()) {
            String line = scnr.nextLine();
            String[] item = line.split(",");
            int id = Integer.parseInt(item[0]);
            String type = item[1];
            
                if (type.equalsIgnoreCase("book")) {
                    addBook(line);
                } else if (type.equalsIgnoreCase("cd")) {
                    addCd(line);
                } else if (type.equalsIgnoreCase("dvd")) {
                    addDvd(line);
                } else {
                    System.out.println("Invalid item type");
                }
            }
        scnr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Exception with inventory file");
            System.out.println(e);
            System.exit(0);
        }
    }
    
    
    private void addBook(String line) {
        String[] item = line.split(",");
        int productId = Integer.parseInt(item[0]);
        String name = item[2];
        String author = item[3];
        int numStock = Integer.parseInt(item[4]);
        double price = Double.parseDouble(item[5]);
        Books book = new Books(name, author, numStock, price, productId);
        books.add(book);
        products.add(book);
    }
    
    private void addCd(String line) {
        String[] item = line.split(",");
        int productId = Integer.parseInt(item[0]);
        String name = item[2];
        String artist = item[3];
        int numStock = Integer.parseInt(item[4]);
        double price = Double.parseDouble(item[5]);
        Cds cd = new Cds(name, artist, numStock, price, productId);
        cds.add(cd);
        products.add(cd);
    }
    
    private void addDvd(String line) {
        String[] item = line.split(",");
        int productId = Integer.parseInt(item[0]);
        String name = item[2];
        String director = item[3];
        int numStock = Integer.parseInt(item[4]);
        double price = Double.parseDouble(item[5]);
        Dvds dvd = new Dvds(name, director, numStock, price, productId);
        dvds.add(dvd);
        products.add(dvd);
    }
    
    /**
     *
     */
    public void EndDay() {
        try {
            FileOutputStream fs = new FileOutputStream("EndDayReport.txt");
            PrintWriter outFs = new PrintWriter(fs);
            outFs.println("We made " + numSales +  " sales today");
            outFs.println("We sold " + booksSoldToday + " books, " + cdsSoldToday + " cds, and " + dvdsSoldToday + " dvds");
            outFs.println("We registered " + newMembersRegistered + " members today");
            outFs.println("We had $" + totalSales + " in sales today");
            outFs.println();
            outFs.flush();
            fs.close();
            
            FileOutputStream fs2 = new FileOutputStream("ItemInventoryDay" + dayNum + ".csv");
            PrintWriter outFs2 = new PrintWriter(fs2);
            outFs2.println("productID,type,title,author/artist,numInStock,price");
            
            for (Product item: products) {
                outFs2.print((item.getProductID()) + "," + item.getClass() + "," + item.getName() + ",");
                outFs2.print(item.getCreator() + "," + item.getStock() + "," + item.getPrice());
                outFs2.println();
            }
            outFs2.flush();
            fs2.close();
        } catch (FileNotFoundException e) {
            System.out.println("exception: File not found");
            System.out.println(e);
        } catch (IOException e) {
            System.out.println("exception: problem closing file");
            System.out.println(e);
            
        }

    }
    
    
    /**
     * gets the inventory for each category
     */
    public void getInventory() {
        System.out.println("Number of books: " + books.size());
        System.out.println("Number of CDs: " + cds.size());
        System.out.println("Number of DVDs: " + dvds.size());
    }
    
    
    
    /**
     * getter for members/customers
     * @param personNum
     * @return
     */
    public Person getCustomer(int personNum) {
        return members.get(personNum);
    }
    
    /**
     * adds book to cart and removes it from inventory
     * @param member
     * @param bookNum
     */
    public void buyBook(Person member,int bookNum) {
        for (int i = 0; i < products.size(); i++){
            if (products.get(i).getProductID() == bookNum) {
                member.addToCart(products.get(i).getPrice());
                this.totalSales += products.get(i).getPrice();
                this.dailyPurchaseList.add(products.get(i));
                this.booksSoldToday++;
                products.get(i).setStock(products.get(i).getStock() - 1);
            }
        }
    }

    /**
     * shows amount of books left after one has been removed
     */
    public void showBooks() {
        for (int i = 0; i < books.size(); i++) {
            System.out.println("Product ID: " + books.get(i).getProductID() + "-> " 
                    + books.get(i).toString());
        }
    }
    
    /**
     * shows amount of CDs left after one has been removed 
     */
    public void showCDs() {
        for (int i = 0; i < cds.size(); i++) {
            System.out.println("Product ID: " + cds.get(i).getProductID() + "-> " + 
                    cds.get(i).toString());
        }
    }

    /**
     * returns the members that are in the database
     * @return
     */
    public static ArrayList<Person> getMembers() {
        return members;
    }

    /**
     * shows amount of DVDs left after one has been removed
     */
    public void showDVDs() {
        for (int i = 0; i < dvds.size(); i++) {
            System.out.println("Product ID: " + dvds.get(i).getProductID() + "-> " + 
                    dvds.get(i).toString());
        }
    }

    /**
     * adds CD to cart and removes one from inventory
     * @param member
     * @param CDNum
     */
    public void buyCD (Person member,int CDNum) {
        for(int i = 0; i < products.size(); i++){
            if (products.get(i).getProductID() == CDNum) {
                member.addToCart(products.get(i).getPrice());
                this.dailyPurchaseList.add(products.get(i));
                this.totalSales += products.get(i).getPrice();
                this.cdsSoldToday++;
                products.get(i).setStock(products.get(i).getStock() - 1);
            }
        }
    }
    
    /**
     * adds DVD to cart and removes one from inventory
     * @param member
     * @param DVDNum
     */
    public void buyDVD (Person member,int DVDNum) {
        for (int i = 0; i < products.size(); i++){
            if (products.get(i).getProductID() == DVDNum) {
                member.addToCart(products.get(i).getPrice());
                this.dailyPurchaseList.add(products.get(i));
                this.totalSales += products.get(i).getPrice();
                this.dvdsSoldToday++;
                products.get(i).setStock(products.get(i).getStock() - 1);
            }
        }

    }

    /**
     * adds person as a member
     * @param person
     */
    public void registerCustomer(Person person) {
        members.add(person);
        newMembersRegistered += 1;
        totalSales += 4.99;
    }

    /**
     * shows member list
     */
    public void memberList() {
        for (int i = 0; i < members.size(); i++) {
            System.out.println((i+1) + ": " + members.get(i).getName());
        }
    }

    /**
     *
     */
    public void showProducts() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println("Product ID: " + products.get(i).getProductID() +
                    " Name: " + products.get(i).toString());
        }
    }

    /**
     *
     * @param productID
     * @param amount
     * @return
     */
    @Override
    public int restockProduct(int productID, int amount) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getProductID() == productID) {
                books.get(i).setStock(books.get(i).getStock() + amount);
                return books.get(i).getStock();
            }
        }
        
        for (int j = 0; j < cds.size(); j++) {
            if (cds.get(j).getProductID() == productID) {
                cds.get(j).setStock(cds.get(j).getStock() + amount);
                return cds.get(j).getStock();
            }
        }
        
        for (int k = 0; k < dvds.size(); k++) {
            if ((dvds.get(k).getProductID()) == productID) {
                dvds.get(k).setStock(dvds.get(k).getStock() + amount);
                return dvds.get(k).getStock();
            }
        }
        
        for (int m = 0; m < products.size(); m++) {
            if (products.get(m).getProductID() == productID) {
                products.get(m).setStock(products.get(m).getStock() + amount);
                return products.get(m).getStock();
            }
        }
        return -1;
    }

    /**
     *
     * @param prodID
     * @return
     */
    public Product findProd(int prodID) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID() == prodID) {
                return products.get(i);
            } 
        }return null;
    }

    /**
     *
     * @return
     */
    @Override
    public double inventoryValue() {
        double value = 0;
        for (int i = 0; i < products.size();i++) {
            value = value + (products.get(i).getPrice() * products.get(i).getStock());
        }
        return value;
    }
    
    
    
}
