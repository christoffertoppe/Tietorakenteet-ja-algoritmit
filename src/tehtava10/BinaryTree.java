/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tehtava10;

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

	public void insert(String aData, int taso) {

		// lis�� juurisolmu
		if (root == null) {
			Node node = new Node(aData);
			System.out.println("New root: " + aData);
			root = node;
			System.out.println("taso: " + taso);
			root.setHeight(taso);
		} else {
			BinaryTree treeNew = new BinaryTree(aData, null, null);	
			// lis�� juuri solmun vasemmalle puolella
			if (root.getData().compareTo(aData) >= 0) {				
				if (root.left() == null) {									
					root.setLeft(treeNew);
					int height = taso + 1;
					treeNew.getNode().setHeight(height);
					System.out.println("taso: " + height);
					System.out.println("First left BinaryTree node: " + aData);
				} else {
					int height = taso +1;
					System.out.println("t�m� on root: " + root.getData());
					root.left().insert(aData, height);
					System.out.println("taso: " + height);
					root.left().getNode().setHeight(height);
					System.out.println("New left BinaryTree node: " + aData);
				}
			}

			// lis�� juurisolmun oikealle puolelle
			else if (root.getData().compareTo(aData) < 0) {
				if (root.right() == null) {
					root.setRight(treeNew);
					int height = taso + 1;
					treeNew.getNode().setHeight(height);
					System.out.println("taso: " + height);
					System.out.println("First right BinaryTree node: " + aData);
				} else {
						int height = taso + 1;
						root.right().insert(aData, height);
						root.right().getNode().getData();
						root.right().getNode().setHeight(height);
						System.out.println("taso: " + height);
						System.out.println("New right BinaryTree node: " + aData);
					}
				}
			}		
	}
	
	
	
	public BinaryTree find(String aData) {

		if (root != null) {
			if(root.getData().equalsIgnoreCase(aData)) {
				System.out.println("l�ytyi");
				return new BinaryTree(root.getData(), root.left(), root.right());
			}
			
			if (root.getData().compareTo(aData) >= 0) {				   
			    if (root.left() != null) { // pääseeekö vasemmalle?
			    	BinaryTree uusi = root.left().find(aData);
			    	return uusi;	
			    }
			}
			if (root.getData().compareTo(aData) < 0) {
				if (root.right() != null) { // pääseekö oikealle?
			    	BinaryTree uusi =	root.right().find(aData);
			    	return uusi;			
				}						
			}	
		
		}
		return null;
	}
	
			
	public void preOrder() {
		if (root != null) {
			System.out.println(root.getData() + "("+ root.getHeight() +")"+ ',');
			if (root.left() != null) { // pääseeekö vasemmalle?
				root.left().preOrder();
			}
			if (root.right() != null) { // pääseekö oikealle?
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
	
	public BinaryTree getNextBinaryTreeParent(BinaryTree startPoint) {	
		
		if (startPoint.getNode().left().getNode().left() != null) { // pääseeekö vasemmalle?
		//if (startPoint.getNode().left() != null) { // pääseeekö vasemmalle?
			startPoint = getNextBinaryTreeParent(startPoint.getNode().left());
		} 

		return startPoint;
	}
	
	public BinaryTree getNextBinaryTreeChild(BinaryTree startPoint) {	
		
		if (startPoint.getNode().left() != null) { // pääseeekö vasemmalle?
			startPoint = getNextBinaryTreeChild(startPoint.getNode().left());
		} 

		return startPoint;
	}


	public BinaryTree remove(String data) {

		if (root != null) {
			if(root.getData().equalsIgnoreCase(data)) {
				if(root.left() == null && root.right() == null) {
					System.out.println("poistettu " + root.getData());
					root = null;
					return null;
				} 
				if(root.left() == null && root.right() != null) {
					int height = root.getHeight();
					root = root.right().getNode();
					root.setHeight(height);
					BinaryTree left = null;
					BinaryTree right = null;
					try {
					left = root.left();
					} catch (Exception e ) {
					}
					try {
					right = root.right();
					} catch (Exception e ) {
					}
					System.out.println(data);
					
					return new BinaryTree(root.getData(), left , right);
				}				
				if(root.left() != null && root.right() == null) {
					int height = root.getHeight();
					root = root.left().getNode();
					root.setHeight(height);
					BinaryTree left = null;
					BinaryTree right = null;
					try {
					left = root.left();
					} catch (Exception e ) {
					}
					try {
					right = root.right();
					} catch (Exception e ) {
					}	
					System.out.println(data);
					return new BinaryTree(root.getData(), left  , right);
				
				} 
				if(root.left() != null && root.right() != null) {
					int height = root.getHeight();
					BinaryTree tree = getNextBinaryTreeParent(root.right());
					System.out.println("1. FOUND: " + tree);
					String value = tree.getNode().left().getNode().getData();
					remove(value);
					tree.setLeft(null);
					tree = getNextBinaryTreeChild(root.right());
					System.out.println("2. FOUND: " + tree);
					tree.setLeft(null);
					BinaryTree left = null;
					BinaryTree right = null;
					try {
					left = root.left();
					} catch (Exception e ) {
					}
					try {
					right = root.right();
					} catch (Exception e ) {
					}					

					Node nodeNew = new Node(value);
					nodeNew.setLeft(null);
					nodeNew.setRight(right);
					root = nodeNew;	
					root.setHeight(height);
					
					return new BinaryTree(root.getData(), root.left(), root.right());
				}
			}
			if (root.getData().compareTo(data) >= 0) {				   
			    if (root.left() != null) { // pääseeekö vasemmalle?
			    	BinaryTree uusi = root.left().remove(data);
			    	return uusi;	
			    }
			}
			if (root.getData().compareTo(data) < 0) {
				if (root.right() != null) { // pääseekö oikealle?
			    	BinaryTree uusi =	root.right().remove(data);
			    	return uusi;			
				}						
			}	
		
		}
		return null;	 
	}
}
