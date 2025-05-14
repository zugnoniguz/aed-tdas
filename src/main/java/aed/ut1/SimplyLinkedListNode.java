package aed.ut1;

public class SimplyLinkedListNode<T> {
	public T data;
	public SimplyLinkedListNode<T> next;

	public SimplyLinkedListNode(T data) {
		this.data = data;
		this.next = null;
	}

	public SimplyLinkedListNode(T data, SimplyLinkedListNode<T> next) {
		this.data = data;
		this.next = next;
	}
}
