package com.birin.datastructures.stacks;

public class StackUsingLinkedList {

	private Node top;

	public void push(int data) {
		Node nodeToBePushed = new Node(data);
		if (top == null) {
			top = nodeToBePushed;
		} else {
			nodeToBePushed.setNext(top);
			top = nodeToBePushed;
		}
	}

	public int top() {
		if (isEmpty()) {
			throw new IllegalStateException("EMPTY STACK");
		} else {
			return top.data;
		}
	}
	
	public int pop(){
		int topValue = top();
		top = top.getNext();
		return topValue;
	}

	public boolean isEmpty() {
		return top == null;
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
