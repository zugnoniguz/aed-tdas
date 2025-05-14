package aed.ut4;

public class BinarySearchTree<K extends Comparable<K>, V> {
	BinarySearchTreeNode<K, V> root;

	public boolean insert(K key, V value) {
		if (this.root == null) {
			this.root = new BinarySearchTreeNode<K, V>(key, value);
			return true;
		}

		return this.root.insert(key, value);
	}

	public BinarySearchTreeNode<K, V> search(Comparable<K> key) {
		if (this.root == null) {
			return false;
		}

		return this.root.search(key);
	}
}
