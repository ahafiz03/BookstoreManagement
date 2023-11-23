/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anumhafizproject1;

/**
 * declares String and double variables for attributes of books
 * @author anum
 */
public class Books extends Product implements BookstoreSpecification{
    private String author;
    private int stock = 0;
    /**
     * refers back to each variable
     * @param title
     * @param author
     * @param stock
     * @param price
     * @param productID
     */
    public Books (String title, String author, int stock, double price, int productID) {
        super(title, price, author, productID);
        this.stock = stock;
    }

    /**
     * gets the author of book
     * @return
     */
    public String getAuthor() {
        return author;
    }

    /**
     * sets the author of book
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
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

    /**
     * prints out all variables together
     * @return
     */
    @Override
    public String toString() {
        return "Book title: " + this.getName() + ", author: " + author 
                + ", price: $" + this.getPrice();
    }

    /**
     *
     * @param book
     * @return
     */
    @Override
    public int compareTo(Product book) {
        if (this.getPrice() > book.getPrice()) {
            return 1;
        } else if (this.getPrice() < book.getPrice()) {
            return -1;
        } else {
            return 0;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @return
     */
    @Override
    public double inventoryValue() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
