/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tehtava22;

import java.util.*;
/**
 *
 * @author kamaj
 */
public class UsingJCAPI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<TrafficCard> cardUsers = new ArrayList<TrafficCard>();
        RandomString rString = new RandomString(10);
        float genBalance;
        TrafficCard myCard;
        Random r = new Random();
        int i;
        for (i = 0; i < 10; i++) {
            genBalance = ((float) r.nextInt(1000) / 10);
            myCard = new TrafficCard(r.nextInt(100), rString.nextString(), genBalance);
            cardUsers.add(myCard);
        }
        System.out.println("Unsorted(with Aggregate operations):");
        cardUsers
        	.stream()
        	.forEach(e -> System.out.println(e.toString()));
        
        System.out.println("\nSorted by balance(ToCompare metod and Aggregate operations):");
        cardUsers
        	.stream()
        	.sorted()
        	.forEach(e -> System.out.println(e.toString()));
        
    }
    
}
