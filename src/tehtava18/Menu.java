/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tehtava18;

import java.util.Random;

/**
 *
 * @author kamaj
 */
public class Menu {
//main alkaa-----------------------------------------------------------------------------
        public static void main(String[] args) {

                        printMenu();

        }
//main loppuu --------------------------------------------------------------------------
//printMenu alkaa------------------------------------------------------------------
        private static void printMenu() {
                char select;
                BinaryTree tree = new BinaryTree();
                String data;
                TreeSetti treeSetti = null;
                Random rand = new Random();
                int maxValue = 100000;
                do {

                        System.out.println("\n\t\t\t1. Lisää "+ maxValue + " avainta.");
                        System.out.println("\t\t\t2. Etsi avaimella.");
                        System.out.println("\t\t\t3. Käy puu läpi esijärjestyksessä.");
                        System.out.println("\t\t\t4. Käy TreeSet l�pi.");
                        System.out.println("\t\t\t0. lopetus ");
                        System.out.print("\n\n"); // tehdään tyhjiä rivejä
                        select = Lue.merkki();
                        switch (select) {
                        case '1':
                         //   System.out.println(data);
                        	long time = System.nanoTime();
                        	long timeSec = System.currentTimeMillis();
                        	treeSetti = new TreeSetti(maxValue);                      
                        	System.out.println("TreeSet: " + (System.nanoTime() - time));
                        	System.out.println("TreeSet: " + (System.currentTimeMillis() - timeSec));
                        	time = System.nanoTime();
                        	timeSec = System.currentTimeMillis();
                    		for (int i = 0; i < maxValue; i++) {
                    			int luku = rand.nextInt(100000);
                    			if(tree.find(luku) == null) {
                    				tree.insert(luku);
                    			}
                    		}
                    		System.out.println("BinaryTree: " + (System.nanoTime() - time));
                    		System.out.println("BinaryTree: " + (System.currentTimeMillis() - timeSec));
                            break;
                        case '2':                           
                                System.out.println("Anna etsittävä avain (kokonaisluku)");
                                data = Lue.rivi();
                                if (tree.find(Integer.parseInt(data)) != null){
                                    System.out.println("Avain löytyi.");
                                }
                                else {
                                    System.out.println("Avainta ei löytynyt.");
                                }                                                          
                            break;
                        case '3':
                            tree.preOrder();
                            char h = Lue.merkki(); // pysäytetään kontrolli
                            break;
                        case '4':
                        	if(treeSetti != null) {
                            treeSetti.printList();
                        	} else 
                        		System.out.println("tyhj��");
                            h = Lue.merkki(); // pysäytetään kontrolli
                            break;  
                        case '0':
                            break;   
                        }
                }
                while (select != '0');
        }
//printMenu loppuu ----------------------------------------------------------------
}

