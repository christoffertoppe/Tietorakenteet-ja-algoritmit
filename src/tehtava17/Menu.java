/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tehtava17;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ExecutionException;

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
		TreeSet<Integer> tree = new TreeSet<Integer>();
		String data;
		do {

			System.out.println("\n\t\t\t1. Lisää avain.");
			System.out.println("\t\t\t2. Search");;
			System.out.println("\t\t\t3. List all");
			System.out.println("\t\t\t0. Lopetus ");
			System.out.print("\n\n"); // tehdään tyhjiä rivejä
			select = Lue.merkki();
			switch (select) {
			case '1':
				System.out.println("Anna uusi avain (kokonaisluku)");
				data = new String(Lue.rivi());
				// System.out.println(data);
				if (!data.isEmpty()) {
					tree.add(Integer.valueOf(data));
				}
				break;
			case '2':
				System.out.println("Anna etsittävä avain (kokonaisluku)");
				data = Lue.rivi();
				if (tree.contains(Integer.valueOf(data)) != false) {
					System.out.println("Avain löytyi.");
				} else {
					System.out.println("Avainta ei löytynyt.");
				}

				break;
			case '3':
				listAll(tree);
				break;
			case '0':
				break;
			}
		} while (select != '0');
	}

//printMenu loppuu ----------------------------------------------------------------

	private static void listAll(SortedSet<Integer> tree) {
		// TODO Auto-generated method stub
		for (Integer luku : tree) {
			System.out.print(luku + ", ");
		}
		if (tree.size() == 0) {
			System.out.println("Lista tyhj�");
		}

	}

}
