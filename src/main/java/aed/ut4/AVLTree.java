package aed.ut4;

import java.util.LinkedList;
import aed.util.Pair;

public class AVLTree<K extends Comparable<K>, V> {
	AVLTreeNode<K, V> root;

	public boolean insert(K key, V value) {
		if (this.root == null) {
			this.root = new AVLTreeNode<K, V>(key, value);
			return true;
		}

		return this.root.insert(key, value);
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
