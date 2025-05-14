package aed.ut3;

public class Queue<T> {
	SimplyLinkedListNode<T> front;
	SimplyLinkedListNode<T> back;

	public Queue() {
		this.front = null;
		this.back = null;
	}

	public void empty() {
		this.front = null;
		this.back = null;
	}

	public T front() {
		return this.front.data;
	}

	public T pop() {
		T tmp = this.front.data;

		if (this.front == this.back) {
			this.front = null;
			this.back = null;
		} else {
			this.front = this.front.next;
		}

		return tmp;
	}

	public void push(T data) {
		SimplyLinkedListNode<T> node = new SimplyLinkedListNode<T>(data);
		if (this.back == null) {
			this.front = node;
			this.back = node;
			return;
		}
		this.back.next = node;
		this.back = node;
	}

	public boolean isEmpty() {
		return this.front == null && this.back == null;
	}
}
