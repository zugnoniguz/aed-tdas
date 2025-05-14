package ut1;

public class SimplyLinkedList<T> {
	private SimplyLinkedListNode<T> root;

	public void insert(T data) {
		if (this.root == null) {
			this.root = new SimplyLinkedListNode<>(data);
			return;
		}

		SimplyLinkedListNode<T> node = this.root;
		while (node.next != null) {
			node = node.next;
		}

		node.next = new SimplyLinkedListNode<>(data);
	}

	public boolean delete(Comparable<T> data) {
		if (this.root == null) {
			return false;
		}

		if (data.compareTo(this.root.data) == 0) {
			this.root = this.root.next;
			return true;
		}

		SimplyLinkedListNode<T> node = this.root;

		while (node.next != null) {
			if (data.compareTo(node.next.data) == 0) {
				node.next = node.next.next;
				return true;
			}
			node = node.next;
		}

		return false;
	}

	public SimplyLinkedListNode<T> search(Comparable<T> data) {
		SimplyLinkedListNode<T> node = this.root;
		while (node != null) {
			if (data.compareTo(node.data) == 0) {
				return node;
			}
			node = node.next;
		}

		return null;
	}
}
