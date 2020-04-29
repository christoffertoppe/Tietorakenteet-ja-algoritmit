package tehtava11;

public class BinarySearch {

	private static int[] lista = null;

	public Boolean find(int data, int startindex, int divide) {
		System.out.println();
		System.out.println("etsitään: " + data);
		try {
		System.out.println("vertaulu luku: " + lista[(lista.length / divide) + startindex]);
		} catch(Exception e) {
			return false;				
		}
		System.out.println("startindex: " + startindex);
		if (lista.length > 0) {
			// if (lista.length % 2 == 0) {
			int luku = lista[(lista.length / divide) + startindex];
			if (luku == data) {
				return true;
			}
			if (data > lista[lista.length / divide + startindex]) {
				System.out.println("suurempi kuin: " + lista[lista.length / divide + startindex]);
				if (lista.length / divide != 0) {
					startindex = startindex + lista.length / divide;
				} else {
					startindex = startindex + 1;
				}
				divide = divide * 2;
				boolean value = find(data, startindex, divide);
				return value;
			}
			if (data < lista[lista.length / divide + startindex]) {
				System.out.println("pienempi kuin: " + lista[lista.length / divide + startindex]);
				divide = divide * 2;
				boolean value = find(data, startindex, divide);
				return value;
			}
		}
		// }
		return false;
	}

	public static void add(int value) {
		try {
		lista = new int[value];
		for (int i = 0; i < value; i++) {
			lista[i] = i;
			System.out.print(lista[i] + ",");
			if (i % 10 == 0) {
				System.out.println();
			}
		}
		System.out.println("added " + value + " numbers to the list");
		} catch (NegativeArraySizeException e) {
		}
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
