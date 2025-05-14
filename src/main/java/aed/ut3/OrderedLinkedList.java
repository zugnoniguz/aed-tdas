package aed.ut3;

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

		OrderedLinkedListNode<T> node = this.root;

		for (; node.next != null; node = node.next) {
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

		int res = data.compareTo(node.data);
		if (res == 0) {
			return false;
		} else if (res < 0) {
			assert false : "no";
		}

		node.next = new OrderedLinkedListNode<T>(data);
		return true;
	}

	public boolean delete(Comparable<T> data) {
		if (this.root == null) {
			return false;
		}

		if (data.compareTo(this.root.data) == 0) {
			this.root = this.root.next;
			return true;
		}

		OrderedLinkedListNode<T> node = this.root;

		while (node.next != null) {
			if (data.compareTo(node.next.data) == 0) {
				node.next = node.next.next;
				return true;
			}
			node = node.next;
		}

		return false;
	}

	public ArrayList<T> toArray() {
		ArrayList<T> arr = new ArrayList<T>();
		OrderedLinkedListNode<T> node = this.root;
		for (; node != null; node = node.next) {
			arr.add(node.data);
		}

		return arr;
	}

	public void printDebug() {
		OrderedLinkedListNode<T> node = this.root;
		for (; node != null; node = node.next) {
			System.out.printf("Node: %s\n", node.data.toString());
		}
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
