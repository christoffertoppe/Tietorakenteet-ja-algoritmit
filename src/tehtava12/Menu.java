/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tehtava12;

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

		System.out.println("Kuinka monta avainta lis‰t‰‰n (kokonaisluku)");
		data = new String(Lue.rivi());
		BinaariKasa kasa = new BinaariKasa(Integer.parseInt(data));

		do {

			System.out.println("\t\t\t1. Lis‰‰ avain.");
			System.out.println("\t\t\t2. Poista pienin.");
			select = Lue.merkki();
			switch (select) {
			case '1':
				try {
					System.out.println("Anna lis‰tt‰v‰ avain (kokonaisluku)");
					data = Lue.rivi();
					kasa.insert(Integer.parseInt(data));
				} catch (Exception e) {

				}
				break;
			case '2':
				try {
					System.out.println("\npoistettu: " + kasa.poistaPienin());
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			case '0':
				break;
			default:
				System.out.println("Kokeile uusiks");
				break;
			}
			kasa.showAll();

		} while (select != '0');
	}
//printMenu loppuu ----------------------------------------------------------------
}
