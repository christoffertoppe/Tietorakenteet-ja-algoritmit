/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tehtava14;

import javax.xml.bind.ParseConversionEvent;

import sun.reflect.generics.tree.Tree;
import tehtava13.Lue;

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
		PostfixLaskin laskin = new PostfixLaskin();

		do {
			
			System.out.println("\t\tPaina joku nappi aloitaaksesi");
			System.out.println("\t\t0. Lopeta ");
			select = Lue.merkki();
			switch (select) {
			case '0':
				break;
			default:
				System.out.println("esim. 3 4 + 5 2 / *  tämä laskutoimitus antaisi 17.5");
				System.out.println("Anna postfix lause:");
				
				data = Lue.rivi();
				String tulos = laskin.laske(data);
				if(tulos.equals("Virheellinen syöte")) {
					System.out.println(tulos);
				} else {
					System.out.println("laskutoimitus antoi tulokseksi: " + tulos);
				}
				break;
			}

		} while (select != '0');
	}
//printMenu loppuu ----------------------------------------------------------------
}
