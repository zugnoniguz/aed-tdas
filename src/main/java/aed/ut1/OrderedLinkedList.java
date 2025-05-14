package aed.ut1;

import java.util.ArrayList;

public class OrderedLinkedList<T extends Comparable<T>> {
	private OrderedLinkedListNode<T> root;

	public boolean insert(T data) {
		if (this.root == null) {
			this.root = new OrderedLinkedListNode<T>(data);
			return true;
		}

		if (data.compareTo(this.root.data) < 0) {
			OrderedLinkedListNode<T> newNode = new OrderedLinkedListNode<T>(data, this.root);
			this.root = newNode;
			return true;
		}

		OrderedLinkedListNode<T> prev = this.root;
		OrderedLinkedListNode<T> node = prev.next;

		for (; node != null; node = node.next, prev = prev.next) {
			int res = data.compareTo(node.data);
			if (res == 0) {
				return false;
			}

			if (res > 0 && data.compareTo(node.next.data) < 0) {
				OrderedLinkedListNode<T> newNode = new OrderedLinkedListNode<T>(data, node.next);
				node.next = newNode;
				return true;
			}
		}

		int res = data.compareTo(prev.data);
		if (res == 0) {
			return false;
		} else if (res < 0) {
			assert false : "no";
		}

		prev.next = new OrderedLinkedListNode<T>(data);
		return true;
	}

	public ArrayList<T> toArray() {
		ArrayList<T> arr = new ArrayList<T>();
		OrderedLinkedListNode<T> node = this.root;
		for (; node != null; node = node.next) {
			arr.add(node.data);
		}

		return arr;
	}

	public boolean isEmpty() {
		return this.root == null;
	}

	public int size() {
		int size = 0;
		OrderedLinkedListNode<T> node = this.root;
		while (node.next != null) {
			++size;
		}

		return size;
	}
}
