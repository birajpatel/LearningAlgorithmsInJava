package com.birin.datastructures.linkedlists;

public class DoublyLinkedList {

	private Node headNode;

	public void main(int[] data) {
		createDoublyLinkedList(data);
		printList();
	}

	public void printList() {
		Node current = headNode;
		System.out.print("Doubly Linked List : ");
		while (current != null) {
			System.out.print(getNodeData(current) + "->");
			current = current.getRight();
		}
		System.out.println();
	}

	private static String getNodeData(Node node) {
		return node == null ? "" : node.toString();
	}

	private void createDoublyLinkedList(int[] data) {
		for (int index = 0; index < data.length; index++) {
			addItemInLinkedList(index, data[index]);
		}
	}

	public void delete(int deletePosition) {
		int listSize = getLinkedListSize();
		if (listSize == 0 || (deletePosition < 0 || deletePosition >= listSize)) {
			System.out.println("Invalid position to delete:" + deletePosition);
			return;
		}
		if (deletePosition == 0) {
			Node currentHead = headNode;
			headNode = currentHead.getRight();
			currentHead = null;
		} else {
			Node previousNode = headNode;
			for (int index = 0; index < deletePosition - 1; index++) {
				previousNode = previousNode.getRight();
			}
			Node currentNode = previousNode.getRight();
			previousNode.setRight(currentNode.getRight());
			Node nextNode = currentNode.getRight();
			if (null != nextNode) {
				nextNode.setLeft(currentNode.getLeft());
			}
			currentNode = null;
		}
	}

	private void addItemInLinkedList(int insertPosition, int nodeData) {
		int listSize = getLinkedListSize();
		if (insertPosition < 0 || insertPosition > listSize + 1) {
			System.out.println("Invalid position to insert:" + insertPosition);
			return;
		}
		Node nodeToInsert = new Node(nodeData);
		if (insertPosition == 0) {
			nodeToInsert.setRight(headNode);
			if(headNode != null){
				headNode.setLeft(nodeToInsert);
			}
			headNode = nodeToInsert;
		} else {
			Node previousNode = headNode;
			for (int index = 0; index < insertPosition - 1; index++) {
				previousNode = previousNode.getRight();
			}
			Node currentNode = previousNode.getRight();
			nodeToInsert.setRight(currentNode);
			if (null != currentNode) {
				currentNode.setLeft(nodeToInsert);
			}
			previousNode.setRight(nodeToInsert);
			nodeToInsert.setLeft(previousNode);
		}
	}

	private int getLinkedListSize() {
		int count = 0;
		Node pointer = headNode;
		while (pointer != null) {
			count++;
			pointer = pointer.getRight();
		}
		return count;
	}

	private class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		@Override
		public String toString() {
			return Integer.toString(getData());
		}
	}

}
