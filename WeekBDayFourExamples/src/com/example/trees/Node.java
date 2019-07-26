package com.example.trees;

public class Node {

	/*
	 * Class containing left and right child of current node and key value
	 */
	int key;
	Node left, right;

	public Node(int item) {
		key = item;
		left = right = null;
	}
}

class BinaryTree {
	// Root of Binary Tree
	Node root;

	BinaryTree(int key) {
		root = new Node(key);
	}

	BinaryTree() {
		root = null;
	}

	public static void main(String[] args) {

		BinaryTree happyTree = new BinaryTree();
		//create root
		happyTree.root = new Node(1);
		
		/*
		 *    1
		 *  /	\
		 * null null
		 */
		
		happyTree.root.left = new Node(2);
		happyTree.root.right = new Node(3);
		/*
		 * 		1
		 * 	/		\
		 * 2		 3
		 */
		
		happyTree.root.left.left = new Node(4);
		/*
		 * 		1
		 * 	/		\
		 * 2		 3
		 * /
		 * 4
		 */
		
	}
}


