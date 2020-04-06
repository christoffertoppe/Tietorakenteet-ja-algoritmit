/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tehtava1;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 *
 * @author chris
 */
public class Stack {

	private ListItem top;
	private int size;

	// muodosta uusi lista-alkio ja vie se pinon huipulle
	public void push(String aData) {
		size++;
		ListItem newTop = new ListItem();
		newTop.setData(aData);
		newTop.setNext(top);
		top = newTop;
	}

	// poista ja palauta alkio pinon huipulta,
	// jos pino tyhj√§ palauta null
	public ListItem pop() {
		if (size >= 1) {
			size--;
			ListItem topRemoved = top;
			top = top.getNext();
			return topRemoved;
		}
		return null;
	}

	// tulosta pinon sis√§lt√∂ muuttamatta pino
	public void printItems() {
		ListItem currentTop = top;
		if (size == 0) {
			System.out.println("tyhj‰‰");
		} else {
			while (currentTop.getNext() != null) {
				System.out.println(currentTop.getData());
				currentTop = currentTop.getNext();

			}
			if (currentTop.getNext() == null) {
				System.out.println(currentTop.getData());
			}

		}
	}

	public int getSize() {
		return size;
	}

}
