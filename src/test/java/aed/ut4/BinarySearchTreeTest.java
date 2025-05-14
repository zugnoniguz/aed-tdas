package aed.ut4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

	private BinarySearchTree<Integer, Integer> bst;

	@BeforeEach
	void setUp() {
		bst = new BinarySearchTree<>();
	}

	@Test
	void testEmptyTree() {
		assertTrue(bst.isEmpty());

		assertEquals(0, bst.size());
		assertEquals(-1, bst.height());
		assertFalse(bst.contains(42));
	}

	@Test
	void testInsertion() {
		assertTrue(bst.isEmpty());

		bst.insert(10, 10);
		assertEquals(1, bst.size());
		assertEquals(0, bst.height());
		assertTrue(bst.contains(10));

		bst.insert(5, 5);
		bst.insert(15, 15);
		assertEquals(3, bst.size());
		assertEquals(1, bst.height());
		assertTrue(bst.contains(5));
		assertTrue(bst.contains(15));
	}

	@Test
	void testSearch() {
		bst.insert(20, 20);
		bst.insert(10, 10);
		bst.insert(30, 30);

		assertTrue(bst.contains(20));
		assertTrue(bst.contains(10));
		assertTrue(bst.contains(30));
		assertFalse(bst.contains(25));
	}

	@Test
	void testDeletionLeaf() {
		bst.insert(10, 10);
		bst.insert(5, 5);
		bst.insert(15, 15);

		assertNotNull(bst.delete(5));
		assertEquals(2, bst.size());
		assertFalse(bst.contains(5));
	}

	@Test
	void testDeletionNodeWithOneChild() {
		bst.insert(10, 10);
		bst.insert(5, 5);
		bst.insert(2, 2);

		assertNotNull(bst.delete(5));
		assertEquals(2, bst.size());
		assertFalse(bst.contains(5));
		assertTrue(bst.contains(2));
	}

	@Test
	void testDeletionNodeWithTwoChildren() {
		bst.insert(20, 20);
		bst.insert(10, 10);
		bst.insert(30, 30);
		bst.insert(5, 5);
		bst.insert(15, 15);

		assertNotNull(bst.delete(10));
		assertEquals(4, bst.size());
		assertFalse(bst.contains(10));
	}

	@Test
	void testDeleteNonexistent() {
		bst.insert(10, 10);

		assertNull(bst.delete(99));
		assertEquals(1, bst.size());
		assertTrue(bst.contains(10));
	}
}
