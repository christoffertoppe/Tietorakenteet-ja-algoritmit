package tehtava6;

import java.util.Iterator;
import java.util.LinkedList;

public class Stack {
	private LinkedList<String> list;

	public Stack() {
		list = new LinkedList<String>();
	}

	public void push(String data) {

		list.add(data);

	}

	public String pop() {
		if (list.size() > 0) {
			String itemRemoved = list.get(list.size() - 1);
			list.remove(list.size() - 1);
			return itemRemoved;
		}
		return "Tyhjä";
	}

	public void printItems() {
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());

	}

	public int getSize() {
		return list.size();
	}

}
