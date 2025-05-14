package aed.ut3;

public class Stack<T> {
	SimplyLinkedListNode<T> top;

	public Stack() {
		this.top = null;
	}

	public void empty() {
		this.top = null;
	}

	public T peek() {
		return this.top.data;
	}

	public T pop() {
		T tmp = this.top.data;
		this.top = this.top.next;
		return tmp;
	}

	public void push(T data) {
		SimplyLinkedListNode<T> node = new SimplyLinkedListNode<T>(data);
		node.next = this.top;
		this.top = node;
	}

	public boolean isEmpty() {
		return this.top == null;
	}
}
