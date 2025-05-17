package aed.ut4;

import java.util.LinkedList;
import aed.util.Pair;

public class AVLTreeNode<K extends Comparable<K>, V> {
	public K key;
	public V value;
	int height;

	AVLTreeNode<K, V> left;
	AVLTreeNode<K, V> right;

	public AVLTreeNode(K key, V value) {
		this.key = key;
		this.value = value;
		this.height = 0;
	}

	private void updateHeight() {
		this.height = Math.max(this.getHeight(this.right), this.getHeight(this.left)) + 1;
	}

	private void LLBalance() {
		AVLTreeNode<K, V> newRight = new AVLTreeNode<K, V>(this.key, this.value);
		newRight.left = this.left.right;
		newRight.right = this.right;
		this.right = newRight;

		this.key = this.left.key;
		this.value = this.left.value;
		this.left = this.left.left;

		this.right.updateHeight();
		this.updateHeight();
	}

	private void RRBalance() {
		AVLTreeNode<K, V> newLeft = new AVLTreeNode<K, V>(this.key, this.value);
		newLeft.right = this.right.left;
		newLeft.left = this.left;
		this.left = newLeft;

		this.key = this.right.key;
		this.value = this.right.value;
		this.right = this.right.right;

		this.left.updateHeight();
		this.updateHeight();
	}

	private void LRBalance() {
		this.left.RRBalance();
		this.LLBalance();
	}

	private void RLBalance() {
		this.right.LLBalance();
		this.RRBalance();
	}

	private int getHeight(AVLTreeNode<K, V> n) {
		return (n == null) ? -1 : n.height;
	}

	private void checkBalance() {
		int diff = this.getHeight(this.right) - this.getHeight(this.left);
		System.out.printf("Diff is %d\n", diff);
		if (diff < -1) {
			// Left
			AVLTreeNode<K, V> node = this.left;
			int childDiff = this.getHeight(node.right) - this.getHeight(node.left);
			System.out.printf("Child diff (L) is %d\n", childDiff);
			if (childDiff <= -1) {
				// LL
				this.LLBalance();
			} else {
				// LR
				this.LRBalance();
			}
		} else if (diff > 1) {
			// Right
			AVLTreeNode<K, V> node = this.right;
			int childDiff = this.getHeight(node.right) - this.getHeight(node.left);
			if (childDiff >= 1) {
				// RR
				this.RRBalance();
			} else {
				// RL
				this.RLBalance();
			}
		} else {
			// Tamos joya
			return;
		}
	}

	public boolean insert(K key, V value) {
		int res = key.compareTo(this.key);
		if (res < 0) {
			if (this.left == null) {
				System.out.printf("Inserting %d to the left of %d\n", key, this.key);
				this.left = new AVLTreeNode<K, V>(key, value);
			} else {
				if (!this.left.insert(key, value)) {
					return false;
				}
			}
		} else if (res > 0) {
			if (this.right == null) {
				System.out.printf("Inserting %d to the right of %d\n", key, this.key);
				this.right = new AVLTreeNode<K, V>(key, value);
			} else {
				if (!this.right.insert(key, value)) {
					return false;
				}
			}
		} else {
			return false;
		}

		System.out.printf("Checking balance for %d\n", this.key);
		this.checkBalance();

		this.updateHeight();
		System.out.printf("New height for %d is %d\n", this.key, this.height);

		System.out.println();

		return true;
	}

	public AVLTreeNode<K, V> delete(Comparable<K> key) {
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

		// TODO: Rebalance
		return this.removeNode();
	}

	private AVLTreeNode<K, V> removeNode() {
		if (this.left == null) {
			return this.right;
		}

		if (this.right == null) {
			return this.left;
		}

		AVLTreeNode<K, V> parent = this;
		AVLTreeNode<K, V> child = this.left;

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

	public LinkedList<Pair<K, V>> inOrder(LinkedList<Pair<K, V>> l) {
		if (this.left != null) {
			this.left.inOrder(l);
		}
		l.add(new Pair<>(this.key, this.value));
		if (this.right != null) {
			this.right.inOrder(l);
		}

		return l;
	}
}
