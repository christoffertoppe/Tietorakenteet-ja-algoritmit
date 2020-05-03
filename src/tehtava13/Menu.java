/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tehtava13;

import javax.xml.bind.ParseConversionEvent;

import sun.reflect.generics.tree.Tree;

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
		String data;
		ClosedHashing hash = new ClosedHashing();

		do {

			System.out.println("\t\t\t1. Lisää avain.");
			System.out.println("\t\t\t2. Etsi avain.");
			System.out.println("\t\t\t3. Tulosta kaikki.");
			System.out.println("\t\t\t0. lopetus ");
			select = Lue.merkki();
			switch (select) {
			case '1':
				try {
					System.out.println("Anna lisättävä avain (kokonaisluku)");
					data = Lue.rivi();
					hash.add(Integer.parseInt(data));
				} catch (Exception e) {
					
				}
				break;
			case '2':
					System.out.println("Anna haettava avain");
					data = Lue.rivi();
					boolean loytyi = hash.find(Integer.parseInt(data));
					if(loytyi == true) System.out.println("Avain löytyi");
					else System.out.println("Avain ei löytynyt");

				break;
			case '3':
				hash.printAll();
			break;
			case '0':
				break;
			default:
				System.out.println("Kokeile uusiks");
				break;
			}

		} while (select != '0');
	}
//printMenu loppuu ----------------------------------------------------------------
}
