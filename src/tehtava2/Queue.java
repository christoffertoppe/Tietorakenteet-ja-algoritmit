package tehtava2;

import tehtava1.ListItem;

public class Queue {
	private ListItem head;
	private ListItem tail;
	private int size;

	// muodosta uusi lista-alkio ja vie se pinon huipulle
	public void push(String aData) {
		size++;
		ListItem newTail = new ListItem();
		newTail.setData(aData);
		newTail.setNext(null);
		if (size == 1) {
			head = newTail;
		} else {
			tail.setNext(newTail);
		}
		tail = newTail;
	}

	// poista ja palauta alkio pinon huipulta,
	// jos pino tyhjÃ¤ palauta null
	public ListItem pop() {
		ListItem headToBeRemoved = head;

		if (size >= 1) {
			size--;
			head = head.getNext();
			return headToBeRemoved;
		} 

		return null;
	}

	// tulosta pinon sisÃ¤ltÃ¶ muuttamatta pino
	public void printItems() {

		ListItem headBackup = head;
		if (size == 0) {
			System.out.println("tyhjää");
		} else if (size >= 1) {
			while (!headBackup.equals(tail)) {
				System.out.println(headBackup.getData());
				headBackup = headBackup.getNext();
			}
			System.out.println(tail.getData());
		}
	}

	public int getSize() {
		return size;
	}

}
