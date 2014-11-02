package com.birin.datastructures.linkedlists;

public class CircularLinkedList {

	private Node headNode;

	public void main(int[] data) {
		createCircularLinkedList(data);
		printLinkedList();
		addItemInLinkedList(0, 709);
		printLinkedList();
	}

	private void createCircularLinkedList(int[] data) {
		for (int index = 0; index < data.length; index++) {
			addItemInLinkedList(index, data[index]);
		}
	}

	private void addItemInLinkedList(int insertPosition, int dataTobeInserted) {
		int listSize = getLinkedListSize();
		if (insertPosition < 0 || insertPosition > listSize + 1) {
			System.out.println("Invalid position to insert:" + insertPosition);
			return;
		}
		Node nodeToInsert = new Node(dataTobeInserted);
		if (insertPosition == 0) {
			if (headNode == null) {
				headNode = nodeToInsert;
			} else {
				Node lastNode = headNode;
				while (lastNode.getNext() != headNode) {
					lastNode = lastNode.getNext();
				}
				nodeToInsert.setNext(headNode);
				lastNode.setNext(nodeToInsert);
				headNode = nodeToInsert;
			}
		} else {
			Node previousNode = headNode;
			for (int index = 0; index < insertPosition - 1; index++) {
				previousNode = previousNode.getNext();
			}
			nodeToInsert.setNext(previousNode.getNext());
			previousNode.setNext(nodeToInsert);
		}
	}

	private void printLinkedList() {
		System.out.print("Circular Linked List : ");
		if (null != headNode) {
			Node current = headNode;
			do {
				System.out.print(getNodeData(current) + "->");
				current = current.getNext();
			} while (current != headNode);
			System.out.print(getNodeData(current));
		}
		System.out.println();
	}

	private static String getNodeData(Node node) {
		if (null != node) {
			return node.toString();
		}
		return "";
	}

	private int getLinkedListSize() {
		int count = 0;
		if (null != headNode) {
			Node previousNode = headNode;
			do {
				previousNode = previousNode.getNext();
				count++;
			} while (previousNode != headNode);
		}
		return count;
	}

	private class Node {

		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = this;
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
