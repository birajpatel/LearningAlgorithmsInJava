package com.birin.datastructures.linkedlists;

public class SinglyLinkedList {

	private Node headNode;

	public void main(int[] data) {
		createSinglyLinkedList(data);
		printList();
		System.out.println("Size " + getLinkedListSize());
		addItemInLinkedList(0, 709);
		printList();
	}

	private void createSinglyLinkedList(int[] data) {
		for (int index = 0; index < data.length; index++) {
			addItemInLinkedList(index, data[index]);
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
			nodeToInsert.setNext(headNode);
			headNode = nodeToInsert;
		} else {
			Node previousNode = headNode;
			for (int i = 0; i < insertPosition - 1; i++) {
				previousNode = previousNode.getNext();
			}
			nodeToInsert.setNext(previousNode.getNext());
			previousNode.setNext(nodeToInsert);
		}
	}

	public int getLinkedListSize() {
		int count = 0;
		Node pointer = headNode;
		while (pointer != null) {
			count++;
			pointer = pointer.getNext();
		}
		return count;
	}

	public void printList() {
		Node current = headNode;
		System.out.print("Singly Linked List : ");
		while (current != null) {
			System.out.print(getNodeData(current) + "->");
			current = current.getNext();
		}
		System.out.println();
	}

	public void delete(int deletePosition) {
		int listSize = getLinkedListSize();
		if (listSize == 0 || (deletePosition < 0 || deletePosition >= listSize)) {
			System.out.println("Invalid position to delete:" + deletePosition);
			return;
		}
		if (deletePosition == 0) {
			Node currentHead = headNode;
			headNode = currentHead.getNext();
			currentHead = null;
		} else {
			Node previousNode = headNode;
			for (int index = 0; index < deletePosition - 1; index++) {
				previousNode = previousNode.getNext();
			}
			Node currentNode = previousNode.getNext();
			previousNode.setNext(currentNode.getNext());
			currentNode = null;
		}
	}

	private static String getNodeData(Node node) {
		if (null != node) {
			return node.toString();
		}
		return "";
	}

	private class Node {

		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return Integer.toString(data);
		}

	}

}
