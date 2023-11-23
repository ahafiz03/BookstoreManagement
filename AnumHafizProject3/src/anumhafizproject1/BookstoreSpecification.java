/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anumhafizproject1;

/**
 *
 * @author anum
 */
public interface BookstoreSpecification {
    /**
     * given a product id and a product quantity, update
     * stock by adding amount to existing product quantity
     * 
     * @param productID
     * @param amount
     * @return
     */
    public int restockProduct(int productID, int amount);

    /**
     *
     * @return
     */
    public double inventoryValue();
}
