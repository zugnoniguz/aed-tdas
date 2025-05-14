package aed.ut3;

import java.util.EmptyStackException;

public class CircularQueue<T> {
	T[] storage;
	int front;
	int back;

	public CircularQueue(int size) {
		this.storage = (T[]) new Object[size];
		this.front = -1;
		this.back = -1;
	}

	private int incrIndex(int index) {
		return (index + 1) % this.storage.length;
	}

	private int decrIndex(int index) {
		int length = this.storage.length;
		int newIndex = (index - 1) % length;
		if (newIndex < 0) {
			newIndex += length;
		}
		return newIndex;
	}

	public void push(T data) {
		if (this.incrIndex(this.back) == this.front) {
			throw new OutOfMemoryError();
		}

		if (this.back == -1) {
			this.back = 0;
			this.front = 0;
			this.storage[this.back] = data;
		} else {
			this.back = this.incrIndex(this.back);
			this.storage[this.back] = data;
		}
	}

	public T front() {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		}
		return this.storage[this.front];
	}

	public T pop() {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		}

		T elem = this.storage[this.front];
		this.front = this.incrIndex(this.front);
		if (this.incrIndex(this.back) == this.front) {
			this.front = -1;
			this.back = -1;
		}
		return elem;
	}

	public boolean isEmpty() {
		return this.front == -1 && this.back == -1;
	}

	public void empty() {
		this.front = -1;
		this.back = -1;
	}

	public int size() {
		if (this.isEmpty()) {
			return 0;
		}

		int res = this.back - this.front;
		if (res < 0) {
			res += this.storage.length;
		}
		res += 1;
		return res;
	}

	public void printQueue() {
		System.out.printf("Front: %d\n", this.front);
		System.out.printf("Back: %d\n", this.back);
		for (int i = 0; i < this.storage.length; ++i) {
			T n = this.storage[i];
			System.out.printf("%d: %s\n", i, n == null ? "null" : n.toString());
		}
	}
}
