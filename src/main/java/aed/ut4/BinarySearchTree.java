package aed.ut4;

import java.util.LinkedList;

import aed.util.Pair;

public class BinarySearchTree<K extends Comparable<K>, V> {
	BinarySearchTreeNode<K, V> root;

	public boolean insert(K key, V value) {
		if (this.isEmpty()) {
			this.root = new BinarySearchTreeNode<K, V>(key, value);
			return true;
		}

		return this.root.insert(key, value);
	}

	public void delete(Comparable<K> key) {
		if (this.isEmpty()) {
			return;
		}

		this.root.delete(key);
	}

	public BinarySearchTreeNode<K, V> search(Comparable<K> key) {
		if (this.isEmpty()) {
			return null;
		}

		return this.root.search(key);
	}

	public boolean contains(Comparable<K> key) {
		if (this.isEmpty()) {
			return false;
		}

		return this.root.contains(key);
	}

	public LinkedList<Pair<K, V>> preOrder() {
		if (this.isEmpty()) {
			return new LinkedList<>();
		}

		return this.root.preOrder();
	}

	public LinkedList<Pair<K, V>> inOrder() {
		if (this.isEmpty()) {
			return new LinkedList<>();
		}

		return this.root.inOrder();
	}

	public LinkedList<Pair<K, V>> postOrder() {
		if (this.isEmpty()) {
			return new LinkedList<>();
		}

		return this.root.postOrder();
	}

	public boolean isEmpty() {
		return this.root == null;
	}

	public int size() {
		if (this.isEmpty()) {
			return 0;
		}
		return this.root.size();
	}

	public int height() {
		if (this.isEmpty()) {
			return -1;
		}
		return this.root.height();
	}
}
