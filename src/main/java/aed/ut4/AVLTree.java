package aed.ut4;

import java.util.LinkedList;
import aed.util.Pair;

public class AVLTree<K extends Comparable<K>, V> {
	AVLTreeNode<K, V> root;

	public AVLTreeNode<K, V> search(Comparable<K> key) {
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

	public boolean insert(K key, V value) {
		if (this.isEmpty()) {
			this.root = new AVLTreeNode<K, V>(key, value);
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

	public boolean isEmpty() {
		return this.root == null;
	}

	public LinkedList<Pair<K, V>> inOrder() {
		LinkedList<Pair<K, V>> l = new LinkedList<>();
		if (this.isEmpty()) {
			return null;
		}

		return this.root.inOrder(l);
	}
}
