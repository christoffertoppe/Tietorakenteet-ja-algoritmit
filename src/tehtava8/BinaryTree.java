/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tehtava8;

import com.sun.org.apache.xml.internal.utils.StringComparable;

/**
 *
 * @author kamaj
 */

import java.util.ArrayList;
import java.util.List;


public class BinaryTree {

	private Node root;

	public BinaryTree() {
		root = null;

	}

	List<String> list = new ArrayList<String>();

	public void clearlist() {
		list.clear();
	}
	
	
	public void list() {
			for(String item: list) {
				System.out.println(item);
			}
		}
	
	
	public BinaryTree(String rootValue, BinaryTree left, BinaryTree right) {
		root = new Node(rootValue, left, right);
	}

	public void insert(String aData) {

		// lis‰‰ juurisolmu
		if (root == null) {
			Node node = new Node(aData);
			System.out.println("New root: " + aData);
			root = node;
		} else {
			BinaryTree treeNew = new BinaryTree(aData, null, null);	
			// lis‰‰ juuri solmun vasemmalle puolella
			if (root.getData().compareTo(aData) >= 0) {				
				if (root.left() == null) {									
					root.setLeft(treeNew);
					System.out.println("First left BinaryTree node: " + aData);
				} else {					
					root.left().insert(aData);	
					System.out.println("New left BinaryTree node: " + aData);
				}
			}

			// lis‰‰ juurisolmun oikealle puolelle
			else if (root.getData().compareTo(aData) < 0) {
				if (root.right() == null) {
					root.setRight(treeNew);
					System.out.println("First right BinaryTree node: " + aData);
				} else {
						root.right().insert(aData);
						System.out.println("New right BinaryTree node: " + aData);
					}
				}
			}		
	}
	
	
	
	public BinaryTree find(String aData) {

		if (root != null) {
			if(root.getData().equalsIgnoreCase(aData)) {
				System.out.println("lˆytyi");
				return new BinaryTree(root.getData(), root.left(), root.right());
			}
			
			if (root.getData().compareTo(aData) >= 0) {				   
			    if (root.left() != null) { // p√§√§seeek√∂ vasemmalle?
			    	BinaryTree uusi = root.left().find(aData);
			    	return uusi;	
			    }
			}
			if (root.getData().compareTo(aData) < 0) {
				if (root.right() != null) { // p√§√§seek√∂ oikealle?
			    	BinaryTree uusi =	root.right().find(aData);
			    	return uusi;			
				}						
			}	
		
		}
		return null;
	}
	
			
	public void preOrder() {
		if (root != null) {
			System.out.println(root.getData() + ',');
			if (root.left() != null) { // p√§√§seeek√∂ vasemmalle?
				root.left().preOrder();
			}
			if (root.right() != null) { // p√§√§seek√∂ oikealle?
				root.right().preOrder();
			}
		}

	}

	public void setLeft(BinaryTree tree) {
		root.setLeft(tree);
	}

	public void setRight(BinaryTree tree) {
		root.setRight(tree);
	}

	public Node getNode() {
		return root;
	}
}
