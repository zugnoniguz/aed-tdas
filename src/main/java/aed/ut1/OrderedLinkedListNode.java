package aed.ut1;

public class OrderedLinkedListNode<T> {
	public T data;
	public OrderedLinkedListNode<T> next;

	public OrderedLinkedListNode(T data) {
		this.data = data;
		this.next = null;
	}

	public OrderedLinkedListNode(T data, OrderedLinkedListNode<T> next) {
		this.data = data;
		this.next = next;
	}

}
