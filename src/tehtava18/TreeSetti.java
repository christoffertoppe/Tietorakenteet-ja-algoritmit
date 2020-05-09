package tehtava18;

import java.util.Random;
import java.util.TreeSet;

public class TreeSetti {

	private int maxValue = 100000;
	private TreeSet<Integer> lukuLista = new TreeSet<Integer>();
	private Random rand = new Random();
	private int laskuri = 0;

	public TreeSetti() {
		laskuri++;
		for (int i = 0; i < maxValue; i++) {
			lukuLista.add(rand.nextInt(100000));
			laskuri++;
		}
	}
		public TreeSetti(int max) {
			maxValue = max;
			laskuri++;
			for (int i = 0; i < maxValue; i++) {
				lukuLista.add(rand.nextInt(100000));
				laskuri++;
			}
		
	}
	
	public void printList() {
		for(Integer luku: lukuLista) {
			System.out.println(luku);
		}
	}
	
	public int getLaskuri() {
		
		return laskuri;
	}
	
	
}
