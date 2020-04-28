package tehtava11;

public class BinarySearch {

	private static int[] lista = null;

	public Boolean find(int data, int[] list) {
		System.out.println("etsitään: " + data);
		try {
			if(list.length == 1) {
				if(list[0] == data) {
					System.out.println("löytyi");
					return true;
				}
				
			} else if(list.length == 2) {
				if(list[0] == data || list[1] == data) {
					return true;
				}
			} else if(list.length == 3) {
			if(list[0] == data || list[1] == data || list[2] == data) {
				return true;
			}
		}
			
		if (list.length > 0) {
			if (list.length % 2 == 0) {
				if (list[list.length / 2] == data) {
					return true;
				}

			} else if (list.length % 2 != 0) {
				if (list[list.length / 2] / 2 == data || list[list.length / 2+ 1] == data) {
					return true;
				}
			}

			if (list.length % 2 == 0) {
				if (data > (list[list.length / 2])) {
					System.out.println("isompi kuin: " + list[(list.length / 2)]);
					int[] uusiLista = new int[list.length / 2];
					int j = 0;
					for (int i = list.length / 2; i < list.length; i++) {
						uusiLista[j] = list[i];
						j++;
					}
					Boolean tulos = find(data, uusiLista);
					return tulos;
				}
				if (data < (list[list.length / 2])) {
					System.out.println("pienempi kuin: " + list[(list.length / 2)]);
					int[] uusiLista = new int[list.length / 2];
					for (int i = 0; i < (list.length / 2); i++) {
						uusiLista[i] = list[i];
					}
					Boolean tulos = find(data, uusiLista);
					return tulos;
				}
			}
			else if (list.length % 2 != 0) {
				if (data > (list[list.length / 2] + 1)) {
					System.out.println("isompi kuin: " + list[(list.length / 2) + 1]);
					int[] uusiLista = new int[list.length / 2 + 1];
					int j = 0;
					for (int i = list.length / 2; i < list.length; i++) {
						uusiLista[j] = list[i];
						j++;
					}
					Boolean tulos = find(data, uusiLista);
					return tulos;
				}
				if (data < (list[list.length / 2 + 1])) {
					System.out.println("pienempi kuin: " + list[(list.length / 2) + 1]);
					int[] uusiLista = new int[list.length / 2];
					for (int i = 0; i < (list.length / 2); i++) {
						uusiLista[i] = list[i];
					}
					Boolean tulos = find(data, uusiLista);
					return tulos;
				}
			}
		} 
		} catch(Exception e) {
			return false;
		}
		return false;
	}

	public static void add(int value) {
		lista = new int[value];
		for (int i = 0; i < value; i++) {
			lista[i] = i;
			System.out.print(lista[i] + ",");
			if (i % 10 == 0) {
				System.out.println();
			}
		}
		System.out.println("added " + value + " numbers to the list");
	}

	public void showAll() {

		// TODO Auto-generated method stub
		if (lista.length != 0) {
			for (int luku : lista) {
				System.out.println(luku);
			}
		}
	}

	public int[] getIntList() {
		return lista;
	}

}
