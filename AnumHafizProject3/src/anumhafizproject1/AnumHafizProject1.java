/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package anumhafizproject1;
import java.util.*;
/**
 * Test Harness class
 * @author anum
 */
public class AnumHafizProject1 {

    /**
     * functions to create an object that represents the bookstore
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num = 0;
        do {
        String filename = "ProductInventory.csv";
        Bookstore bookstore = new Bookstore(filename);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Automated Bookstore System!");
        System.out.println("If you have not already created a user you will "
                + "be directed to do so below immediately no matter what you "
                + "select.");
        System.out.println("Please select one of the options from below, "
                + "by typing a number");
        System.out.println("1. Make a purchase");
        System.out.println("2. Check membership dues");
        System.out.println("3. Register a new member");
        System.out.println("4. Compare prices of items");
        System.out.println("5. Restock product(s)");
        System.out.println("6. Close Store/Exit");
        
        num = scanner.nextInt();
        if (bookstore.getMembers().size() == 0 && num != 4){
            num = 3;
        }
            switch (num) {
                case 1:
                    System.out.println("Select the number corresponding to your"
                            + " name in the list below:");
                    bookstore.memberList();
                    int memberNum = scanner.nextInt();
                    Person currentMember = bookstore.getCustomer(memberNum - 1);
                    int categoryNum = 0;
                    do {
                        System.out.println("Select the number corresponding "
                                + "to an item category below:");
                        System.out.println("1. Books");
                        System.out.println("2. CDs");
                        System.out.println("3. DVDs");
                        System.out.println("4. I am done shopping?");
                        categoryNum = scanner.nextInt();
                        switch (categoryNum) {
                            case 1:
                                System.out.println("Choose a book to purchase");
                                bookstore.showBooks();
                                int bookNum = scanner.nextInt();
                                bookstore.buyBook(currentMember, bookNum);
                                System.out.println("");
                                continue;
                            case 2:
                                System.out.println("Choose a CD to purchase");
                                bookstore.showCDs();
                                int CDNum = scanner.nextInt();
                                bookstore.buyCD(currentMember, CDNum);
                                System.out.println("");
                                continue;
                            case 3:
                                System.out.println("Choose a DVD to purchase");
                                bookstore.showDVDs();
                                int DVDNum = scanner.nextInt();
                                bookstore.buyDVD(currentMember, DVDNum);
                                System.out.println("");
                                continue;
                            case 4:
                                currentMember.setMoneySpent
                                (currentMember.getCart());
                                System.out.println("You have spent $" + 
                                        currentMember.getCart() + " today and $" 
                                        + currentMember.getMoneySpent() + 
                                        " in total");
                                System.out.println("");
                                continue;
                            default:
                                System.out.println("Please select a valid "
                                        + "option");
                        }
                    } while (categoryNum != 4);
                    break;
                case 2:
                    System.out.println("Select the number corresponding to "
                            + "your name in the list below:");
                    bookstore.memberList();
                    int premMemberNum = scanner.nextInt();
                    Person premMember = bookstore.getCustomer
                        (premMemberNum - 1);
                    if (premMember.isHasPremium()) {
                        System.out.println("You do not have any dues");
                        System.out.println("");
                    }   else {
                            if (!premMember.isPremiumPaid()) {
                                System.out.println("You owe $" + 
                                        Person.getPremiumCost());
                                System.out.println("Would you like to pay your"
                                        + " dues now? Enter the number "
                                        + "corresponding to your answer:");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                int yesNo = scanner.nextInt();
                                switch (yesNo) {
                                    case 1:
                                        premMember.setMoneySpent
                                        (Person.getPremiumCost());
                                        premMember.setPremiumPaid(true);
                                        System.out.println("You have now paid "
                                                + "your dues");
                                        System.out.println("");
                                        continue;
                                    case 2:
                                        System.out.println("You have chosen "
                                                + "to not pay your dues. You "
                                                + "will face the consequences"
                                                + " soon.");
                                        System.out.println("");
                                        continue;
                                    default:
                                        System.out.println("Please select a "
                                                + "valid option.");
                                }
                            }
                    }
                    break;
                case 3:
                    System.out.println("Please enter your name:");
                    String random;
                    random = scanner.nextLine();
                    String name = scanner.nextLine();
                    
                    System.out.println();
                    System.out.println("Please enter whether or not you would"
                            + " like a premium membership. This would cost $" 
                            + (Person.getPremiumCost()) + " per month");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    int yesNoPrem = scanner.nextInt();
                    switch (yesNoPrem) {
                        case 1:
                            Person newPremMember = new Person(name, true);
                            bookstore.registerCustomer(newPremMember);
                            System.out.println("You are now a new premium "
                                    + "member");
                            System.out.println("");
                            continue;
                        case 2:
                            Person newMember = new Person(name, false);
                            bookstore.registerCustomer(newMember);
                            System.out.println("You are now a new free member");
                            System.out.println("");
                            continue;
                        default:
                            System.out.println("Please select a valid option");
                    }
                case 4:
                    System.out.println("Select the numbers corresponding to the "
                            + "two products you would like to compare the prices "
                            + "of: ");
                    bookstore.showProducts();
                    
                    int comp1 = scanner.nextInt();
                    int comp2 = scanner.nextInt();
                    
                    Product prod1 = bookstore.findProd(comp1);
                    Product prod2 = bookstore.findProd(comp2);
                    if (prod1 != null && prod2 != null){
                        if (prod1.compareTo(prod2) > 0) {
                            System.out.println("Product 1 is more expensive than"
                                    + " Product 2");
                        } else if (prod1.compareTo(prod2) < 0 ) {
                            System.out.println("Product 2 is more expensive than"
                                    + " Product 1");
                        } else {
                            System.out.println("Both of these are the same price");
                        }
                    } else {
                        System.out.println("One of these products does not exist");
                    }
                    break;
                case 5:
                    System.out.println("Choose a product to restock");
                    bookstore.showProducts();
                    int prodSelect = scanner.nextInt();
                    System.out.println("Now choose how much to restock");
                    int quantSelect = scanner.nextInt();
                    bookstore.restockProduct(prodSelect, quantSelect);
                    System.out.println("You have now restocked selected item.");
                    break;
                case 6:
                    bookstore.EndDay();
                    System.exit(0);
            } 
        } while (num != 6);
    }
}
