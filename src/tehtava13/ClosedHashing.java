package tehtava13;

public class ClosedHashing {
	private int[] lista;
	private int listaKoko = 7;

	public ClosedHashing() {
		lista = new int[this.listaKoko];
	}

	public void add(int uusiLuku) {
		boolean etsitaan = true;
		int i = 0;
		while (etsitaan) {
			int ind = (uusiLuku + i) % listaKoko;
			if (lista[ind] == 0) {
				lista[ind] = uusiLuku;
				System.out.println("lisätty luku: " + uusiLuku + " paikalle: " + ind);
				etsitaan = false;
			} else {
				i++;
				if (i == listaKoko) {
					System.out.println("Lista täynnä");
					etsitaan = false;
				}
			}
		}
	}

	public boolean find(int uusiLuku) {
		boolean etsitaan = true;
		int i = 0;
		while (etsitaan) {
			int ind = (uusiLuku + i) % listaKoko;
			if (lista[ind] == uusiLuku) {
				return true;
			} else {
				i++;
				if (i == listaKoko) {
					etsitaan = false;
				}
			}
		}
		return false;
	}
	
	public void printAll() {
		for (int i = 0; i < lista.length; i++) {
			if (lista[i] == 0) {
				System.out.print("Null, ");
			} else {
				System.out.print(lista[i] + ", ");
			}
			if (i % 10 == 0 && i != 0) {
				System.out.println();
			}

		}
		System.out.println();
	}
}
