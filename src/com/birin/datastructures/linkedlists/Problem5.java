package com.birin.datastructures.linkedlists;

// Find nth element from end.
public class Problem5 {

	private SinglyLinkedList list;

	public Problem5(int[] data) {
		list = new SinglyLinkedList();
		list.main(data);
	}

	// Keep 2 pointers & in first step just move one pointer by n steps then
	// once n step is crossed, move both.
	public SinglyLinkedList.Node solution(int n) {
		SinglyLinkedList.Node temp = list.getHeadNode();
		SinglyLinkedList.Node nThNode = list.getHeadNode();
		for (int i = 0; i < n; i++) {
			if (temp == null) {
				break;
			}
			temp = temp.getNext();
		}
		while (temp != null) {
			temp = temp.getNext();
			nThNode = nThNode.getNext();
		}
		return nThNode;
	}
}
