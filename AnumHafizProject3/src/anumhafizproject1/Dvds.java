/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anumhafizproject1;

/**
 * declares String and double variables for attributes of DVDs
 * @author anum
 */
public class Dvds extends Product {
    private String director;
    private int stock = 0;
    
    /**
     * refers back to the variables
     * @param movieName
     * @param director
     * @param stock
     * @param price
     * @param productID
     */
    public Dvds (String movieName, String director,int stock,  double price, int productID) {
        super(movieName, price, director, productID);
        this.stock = stock;
    }


    /**
     * gets the director of DVD
     * @return
     */
    public String getDirector() {
        return director;
    }

    /**
     * sets the director of DVD
     * @param director
     */
    public void setDirector(String director) {
        this.director = director;
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
        return "DVD Title: " + this.getName() + ", director: " + director + 
                ", price: $" + this.getPrice();
    }

    /**
     *
     * @param dvd
     * @return
     */
    public int compareTo(Product dvd) {
        if (dvd.getPrice() > this.getPrice()) {
            return -1;
        } else if (this.getPrice() > dvd.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    }
}
