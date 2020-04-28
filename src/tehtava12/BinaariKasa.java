package tehtava12;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class BinaariKasa {
	private static final int solmunlapset = 2;
	private int kasanKoko;
	private int[] kasa;

	public BinaariKasa(int koko) {
		kasanKoko = 0;
		kasa = new int[koko + 1];
		Arrays.fill(kasa, -1);
	}

	public Boolean isEmpty() {
		return kasanKoko == 0;
	}

	public boolean isFull() {
		return kasanKoko == kasa.length;
	}

	public void insert(int luku) {
		if (isFull()) {
			throw new NoSuchElementException("lista on täynnä");
		}
		kasa[kasanKoko++] = luku;
		kasaLaajenna(kasanKoko - 1);

	}

	private int getChild(int i, int k) {
		return solmunlapset * i + k;
	}

	private int parent(int i) {
		return (i - 1) / solmunlapset;
	}

	private void kasaLaajenna(int childInd) {
		int tmp = kasa[childInd];
		while (childInd > 0 && tmp < kasa[parent(childInd)]) {
			kasa[childInd] = kasa[parent(childInd)];
			childInd = parent(childInd);
		}
		kasa[childInd] = tmp;
	}

	public void showAll() {
		System.out.print("\nKasa: ");
		for (int i = 0; i < kasanKoko; i++) {
			System.out.print(kasa[i] + " ");
		}
		System.out.println();

	}

	public int poistaPienin() {
		int arvo = kasa[0];
		poista(0);
		return arvo;
	}

	public int poista(int i) {
		if (isEmpty()) {
			throw new NoSuchElementException("Exception");
		}
		int arvo = kasa[i];
		kasa[i] = kasa[kasanKoko - 1];
		kasanKoko--;
		kasaPienenna(i);
		return arvo;
	}

	private void kasaPienenna(int i) {
		int child;
		int tmp = kasa[i];
		while (getChild(i, 1) < kasanKoko) {
			child = pieninLuku(i);
			if (kasa[child] < tmp)
				kasa[i] = kasa[child];
			else
				break;
			i = child;
		}
		kasa[i] = tmp;
	}

	private int pieninLuku(int i) {
		int luku = getChild(i, 1);
		int k = 2;
		int pos = getChild(i, k);
		while ((k <= solmunlapset) && (pos < kasanKoko)) {
			if (kasa[pos] < kasa[luku])
				luku = pos;
			pos = getChild(i, k++);
		}
		return luku;
	}

}
