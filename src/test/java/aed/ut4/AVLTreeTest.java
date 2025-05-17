package aed.ut4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AVLTreeTest {

	private AVLTree<Integer, Integer> bst;

	@BeforeEach
	void setUp() {
		bst = new AVLTree<>();
	}

	@Test
	void emptyWorks() {
		assertTrue(bst.isEmpty());
	}

	@Test
	void addWorks() {
		assertTrue(bst.isEmpty());

		assertTrue(bst.insert(10, 10));
		assertTrue(bst.insert(5, 5));
		assertTrue(bst.insert(2, 2));
		assertTrue(bst.insert(3, 3));
		assertTrue(bst.insert(6, 6));
		assertTrue(bst.insert(7, 7));
		assertTrue(bst.insert(8, 8));

		assertFalse(bst.insert(6, 3));
		assertFalse(bst.insert(5, 4));
	}
}
