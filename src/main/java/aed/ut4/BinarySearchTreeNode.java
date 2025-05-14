package aed.ut4;

import java.util.LinkedList;

import aed.util.Pair;

public class BinarySearchTreeNode<K extends Comparable<K>, V> {
	K key;
	V value;
	BinarySearchTreeNode<K, V> left;
	BinarySearchTreeNode<K, V> right;

	public BinarySearchTreeNode(K key, V value) {
		this.key = key;
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public boolean insert(K key, V value) {
		int res = key.compareTo(this.key);
		if (res < 0) {
			if (this.left == null) {
				this.left = new BinarySearchTreeNode<K, V>(key, value);
				return true;
			}
			return this.left.insert(key, value);
		} else if (res > 0) {
			if (this.right == null) {
				this.right = new BinarySearchTreeNode<K, V>(key, value);
				return true;
			}
			return this.right.insert(key, value);
		} else {
			return false;
		}
	}

	public BinarySearchTreeNode<K, V> search(Comparable<K> key) {
		int res = key.compareTo(this.key);
		if (res < 0) {
			if (this.left == null) {
				return null;
			}
			return this.left.search(key);
		} else if (res > 0) {
			if (this.right == null) {
				return null;
			}
			return this.right.search(key);
		} else {
			return null;
		}
	}

	public BinarySearchTreeNode<K, V> delete(Comparable<K> key) {
		int res = key.compareTo(this.key);
		if (res < 0) {
			if (this.left != null) {
				this.left = this.left.delete(key);
			}
			return this;
		} else if (res > 0) {
			if (this.right != null) {
				this.right = this.right.delete(key);
			}
			return this;
		}

		return this.removeNode();
	}

	private BinarySearchTreeNode<K, V> removeNode() {
		if (this.left == null) {
			return this.right;
		}

		if (this.right == null) {
			return this.left;
		}

		BinarySearchTreeNode<K, V> parent = this;
		BinarySearchTreeNode<K, V> child = this.left;

		while (child.right != null) {
			parent = child;
			child = child.right;
		}

		if (parent != this) {
			parent.right = child.left;
			child.left = this.left;
		}

		child.right = this.right;
		return child;
	}

	public LinkedList<Pair<K, V>> preOrder() {
		LinkedList<Pair<K, V>> l = new LinkedList<>();
		LinkedList<Pair<K, V>> rightList = new LinkedList<>();
		LinkedList<Pair<K, V>> leftList = new LinkedList<>();
		if (this.left != null) {
			rightList.addAll(this.left.preOrder());
		}

		if (this.right != null) {
			leftList.addAll(this.right.preOrder());
		}

		l.add(new Pair<>(this.key, this.value));
		l.addAll(rightList);
		l.addAll(leftList);
		return l;
	}

	public LinkedList<Pair<K, V>> inOrder() {
		LinkedList<Pair<K, V>> l = new LinkedList<>();
		LinkedList<Pair<K, V>> rightList = new LinkedList<>();
		LinkedList<Pair<K, V>> leftList = new LinkedList<>();
		if (this.left != null) {
			rightList.addAll(this.left.inOrder());
		}

		if (this.right != null) {
			leftList.addAll(this.right.inOrder());
		}

		l.addAll(rightList);
		l.add(new Pair<>(this.key, this.value));
		l.addAll(leftList);
		return l;
	}

	public LinkedList<Pair<K, V>> postOrder() {
		LinkedList<Pair<K, V>> l = new LinkedList<>();
		LinkedList<Pair<K, V>> rightList = new LinkedList<>();
		LinkedList<Pair<K, V>> leftList = new LinkedList<>();
		if (this.left != null) {
			rightList.addAll(this.left.postOrder());
		}

		if (this.right != null) {
			leftList.addAll(this.right.postOrder());
		}

		l.addAll(rightList);
		l.addAll(leftList);
		l.add(new Pair<>(this.key, this.value));
		return l;
	}
}
