/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tehtava11;

import javax.xml.bind.ParseConversionEvent;

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
        	BinarySearch tree = new BinarySearch();
                char select;
                String data;
                do {

                        System.out.println("\n\t\t\t1. Lisää haluttu m���r� avaimia.");
                        System.out.println("\t\t\t2. Etsi avaimella.");
                        System.out.println("\t\t\t3. Tulosta kaikki.");
                        System.out.print("\n\n"); // tehdään tyhjiä rivejä
                        select = Lue.merkki();
                        switch (select) {
                        case '1':
                            System.out.println("Kuinka monta avainta lis�t��n (kokonaisluku)");
                            data = new String(Lue.rivi());
                            BinarySearch.add(Integer.parseInt(data));
                            
                         //   System.out.println(data);
                            break;
                        case '2':                           
                                System.out.println("Anna etsittävä avain (kokonaisluku)");
                                data = Lue.rivi();                              
                                if (tree.find(Integer.parseInt(data), tree.getIntList()) != false){
                                    System.out.println("Avain löytyi.");
                                }
                                else {
                                    System.out.println("Avainta ei löytynyt.");
                                }
                                                           
                            break;
                        case '3':
                        	try {
                        	tree.showAll();
                        	} catch(Exception e) {
                        		
                        	}
                        	break;
                        case '0':
                            break;   
                        }
                }
                while (select != '0');
        }
//printMenu loppuu ----------------------------------------------------------------
}

