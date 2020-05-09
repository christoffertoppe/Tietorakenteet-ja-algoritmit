/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tehtava18;

/**
 *
 * @author kamaj
 */
public class Node {
  //  private String data;
	private int data;
    private BinaryTree left;
    private BinaryTree right;

    public Node(int value) {
        data = value;
        left = right = null;
    }
    public  Node (int value, BinaryTree left, BinaryTree right) {
    	data = value;
        this.left = left;
        this.right = right;
    }
    public int getData() {
        return data;
    }
    public BinaryTree left() {
        return left;
    }
    public BinaryTree right() {
        return right;
    }
    public void setLeft(BinaryTree tree) {
        left = tree;
    }
    public void setRight(BinaryTree tree) {
        right = tree;
    }


}
