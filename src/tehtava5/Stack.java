/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tehtava5;

/**
 *
 * @author kamaj
 */
public class Stack {

	ListItem top; // top näkyy oletuspakkaukseen
	private int size;
	private int max_size = 10;
	private ListItem[] listOfListItems = new ListItem[max_size];

	public Stack() {
		top = null;
		size = 0;
	}

	// palautetaan pino-iteraattori
	public StackIterator iterator() {
		return new StackIterator(this);
	}

	// muodostetaan uusi alkio ja viedään se huipulle
	public void push(String aData) {
		if (size < max_size) {
			
			ListItem newItem = new ListItem(); // luodaan uusi lista-alkio
			newItem.setData(aData);
			listOfListItems[size] = newItem;
			size++;
		}
	}

	// poistetaan alkio pinon huipulta, jos pinossa ei alkioita palautetaan null
	public ListItem pop() {
		if(size > 0) {
			size--;
			ListItem listItemRemoved = listOfListItems[size];
			listOfListItems[size] = null;
			return listItemRemoved;
		}
		return null;
	}

	// palautetaan pinottujen alkioiden lukumäärä
	public int getSize() {
		return size;
	}

	// listataan sisältö
	public void printItems() {
		for (ListItem item : listOfListItems) {
			try {
				System.out.println(item.getData());
			} catch (Exception e) {

			}

		}
	}
}
