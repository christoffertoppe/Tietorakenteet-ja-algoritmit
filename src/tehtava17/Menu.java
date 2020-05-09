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
		int root = -1;

		SortedSet<Integer> tree = new TreeSet<Integer>();
		String data;
		do {

			System.out.println("\n\t\t\t1. Lisää avain.");
			System.out.println("\t\t\t2. Search");
			System.out.println("\t\t\t3. inOrder");
			System.out.println("\t\t\t4. preOrder");
			System.out.println("\t\t\t5. List all");
			System.out.println("\t\t\t0. lopetus ");
			System.out.print("\n\n"); // tehdään tyhjiä rivejä
			select = Lue.merkki();
			switch (select) {
			case '1':
				System.out.println("Anna uusi avain (merkkijono)");
				data = new String(Lue.rivi());
				// System.out.println(data);
				if (!data.isEmpty()) {
					tree.add(Integer.valueOf(data));
					if (root == -1) {
						root = Integer.parseInt(data);
					}
				}
				break;
			case '2':
				System.out.println("Anna etsittävä avain (merkkijono)");
				data = Lue.rivi();
				if (find(data) != false) {
					System.out.println("Avain löytyi.");
				} else {
					System.out.println("Avainta ei löytynyt.");
				}

				break;
			case '3':
				inOrder(tree);

				break;
			case '4':
				try {
					preOrder(tree, root);
				} catch (Exception e) {

				}
				break;
			case '5':
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
			System.out.println(luku);
		}
		if (tree.size() == 0) {
			System.out.println("Lista tyhj�");
		}

	}

	private static void inOrder(SortedSet<Integer> tree) {

	}

	private static void preOrder(SortedSet<Integer> tree, int root) {

		System.out.println(root);
		System.out.println(tree.headSet(root));
		System.out.println(tree.tailSet(root));
	}

	private static boolean find(String data) {
		return false;

	}

}
