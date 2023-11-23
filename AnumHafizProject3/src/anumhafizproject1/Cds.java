/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anumhafizproject1;

/**
 * declares String and double variables for attributes of CDS
 * @author anum
 */
public class Cds extends Product implements BookstoreSpecification{
    private String artist;
    private int stock = 0;
    /**
     * refers back to the variables
     * @param album
     * @param artist
     * @param stock
     * @param price
     * @param productID
     */
    public Cds (String album, String artist,int stock, double price, int productID) {
        super(album, price, artist, productID);
        this.stock = stock;
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
     * gets the artist of CD
     * @return
     */
    public String getArtist() {
        return artist;
    }

    /**
     * sets the artist of CD
     * @param artist
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }


    /**
     * prints out all variables together
     * @return
     */
    @Override
    public String toString() {
        return "CD album: " + this.getName() + ", artist: " + artist + ", price: $" 
                + this.getPrice();
    }

    /**
     *
     * @param cds
     * @return
     */
    public int compareTo(Product cds) {
        if (this.getPrice() > cds.getPrice()) {
            return 1;
        } else if (this.getPrice() < cds.getPrice()) {
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
