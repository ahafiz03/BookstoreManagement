/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anumhafizproject1;

/**
 * creates and initializes variables
 * @author anum
 */
public class Person {
    private String name;
    private boolean hasPremium = false;
    private boolean premiumPaid = false;
    private static double premiumCost = 4.99;
    private double moneySpent = 0.0;
    private double cart = 0.0;
    
    /**
     * member that has premium membership
     * @param name
     * @param hasPremium
     */
    public Person (String name, boolean hasPremium) {
        this.name = name;
        this.hasPremium = hasPremium;
    }

    /**
     * name of member
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of member
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * premium membership member 
     * @return
     */
    public boolean isHasPremium() {
        return hasPremium;
    }

    /**
     * sets the premium membership member
     * @param hasPremium
     */
    public void setHasPremium(boolean hasPremium) {
        this.hasPremium = hasPremium;
    }

    /**
     * person who has paid their dues for premium membership
     * @return
     */
    public boolean isPremiumPaid() {
        return premiumPaid;
    }

    /**
     * sets person who has paid their dues for premium membership
     * @param premiumPaid
     */
    public void setPremiumPaid(boolean premiumPaid) {
        this.premiumPaid = premiumPaid;
    }

    /**
     * gets the premium membership cost
     * @return
     */
    public static double getPremiumCost() {
        return premiumCost;
    }

    /**
     * gets the money spent on products
     * @return
     */
    public double getMoneySpent() {
        return moneySpent;
    }

    /**
     * sets the money spent on products
     * @param moneySpent
     */
    public void setMoneySpent(double moneySpent) {
        this.moneySpent = this.moneySpent + moneySpent;
    }
    
    /**
     * adds cost amount to cart cost
     * @param amount
     */
    public void addToCart(double amount) {
        this.cart = this.cart + amount;
    }

    /**
     * gets the cost of the cart
     * @return
     */
    public double getCart() {
        return this.cart;
    }
    
}
