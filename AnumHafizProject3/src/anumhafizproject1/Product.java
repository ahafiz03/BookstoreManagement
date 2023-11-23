/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anumhafizproject1;

/**
 *
 * @author anum
 */
public abstract class Product implements Comparable<Product> {
    private String name;
    private double price;
    private String creator;
    private int productID;

    /**
     *
     * @return
     */
    public String getCreator() {
        return creator;
    }
    
    /**
     *
     * @param creator
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     *
     * @return
     */
    public int getStock() {
        return stock;
    }

    /**
     *
     * @param stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    private int stock = 0;
    
    /**
     *
     * @param name
     * @param price
     * @param creator
     * @param productID
     */
    public Product(String name, double price, String creator, int productID) {
        this.name = name;
        this.price = price;
        this.creator = creator;
        this.productID = productID;
                
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @return
     */
    public int getProductID() {
        return productID;
    }

    /**
     *
     * @param productID
     */
    public void setProdID(int productID) {
        this.productID = productID;
    }

    /**
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }
} 
