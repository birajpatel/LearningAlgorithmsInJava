package com.birin.datastructures;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

	Node treeRoot = null;

	public void main(int[] input) {
		createBST(input);
		System.out.println(TreePrinter.getString(this));
	}

	private void createBST(int[] input) {
		for (int i = 0; i < input.length; i++) {
			int dataTobeInserted = input[i];
			if (treeRoot == null) {
				treeRoot = Node.createNodeInstance(dataTobeInserted, null);
			} else {
				insertAtCorrectPosition(input[i], treeRoot);
			}
		}
	}

	private void insertAtCorrectPosition(int input, Node parent) {
		System.out.print("biraj input : " + input + " parent data " + parent.data + " ");
		if (parent.isDataLesserThanOrEqualto(input)) {
			System.out.print("left ");
			if (parent.isLeftEmpty()) {
				System.out.print("insert ");
				parent.left = Node.createNodeInstance(input, parent);
			} else {
				System.out.println("sub tree ");
				insertAtCorrectPosition(input, parent.left);
			}
		} else {
			System.out.print("right ");
			if (parent.isRightEmpty()) {
				System.out.print("insert ");
				parent.right = Node.createNodeInstance(input, parent);
			} else {
				System.out.println("sub tree ");
				insertAtCorrectPosition(input, parent.right);
			}
		}
		System.out.println();
	}
}

class Node {
	int data;
	Node parent;
	Node left;
	Node right;

	Node(int data, Node parent) {
		this.data = data;
		this.parent = parent;
	}

	public static Node createNodeInstance(int data, Node parent) {
		return new Node(data, parent);
	}

	boolean isLeafNode() {
		return isLeftEmpty() && isRightEmpty();
	}

	boolean isLeftEmpty() {
		return left == null;
	}

	boolean isRightEmpty() {
		return right == null;
	}

	boolean isTreeRoot() {
		return parent == null;
	}

	boolean isDataLesserThanOrEqualto(int data) {
		return this.data >= data;
	}

	boolean isDataGreaterThan(int data) {
		return this.data < data;
	}
}

class TreePrinter {

	public static <T> String getString(BinarySearchTree tree) {
		if (tree.treeRoot == null)
			return "Tree has no nodes.";
		return getString(tree.treeRoot, "", true);
	}

	private static <T> String getString(Node node, String prefix, boolean isTail) {
		StringBuilder builder = new StringBuilder();

		if (node.parent != null) {
			String side = "left";
			if (node.equals(node.parent.right))
				side = "right";
			builder.append(prefix + (isTail ? "└── " : "├── ") + "(" + side
					+ ") " + node.data + "\n");
		} else {
			builder.append(prefix + (isTail ? "└── " : "├── ") + node.data
					+ "\n");
		}
		List<Node> children = null;
		if (node.left != null || node.right != null) {
			children = new ArrayList<Node>(2);
			if (node.left != null)
				children.add(node.left);
			if (node.right != null)
				children.add(node.right);
		}
		if (children != null) {
			for (int i = 0; i < children.size() - 1; i++) {
				builder.append(getString(children.get(i), prefix
						+ (isTail ? "    " : "│   "), false));
			}
			if (children.size() >= 1) {
				builder.append(getString(children.get(children.size() - 1),
						prefix + (isTail ? "    " : "│   "), true));
			}
		}

		return builder.toString();
	}
}