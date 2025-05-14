package aed.ut3;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimplyLinkedTest {
	private SimplyLinkedList<Integer> list;

	@BeforeEach
	void init() {
		list = new SimplyLinkedList<>();
	}

	@Test
	public void emptyList_isEmpty() {
		assertTrue(list.isEmpty());
	}

	@Test
	public void nonEmptyList_isNonEmpty() {
		assertTrue(list.isEmpty());

		list.insert(5);

		assertFalse(list.isEmpty());
	}

	@Test
	public void canAddElementToList() {
		assertTrue(list.isEmpty());

		list.insert(5);
		list.insert(6);
		list.insert(7);

		assertFalse(list.isEmpty());
		assertArrayEquals(list.toArray().toArray(), new Object[] { 5, 6, 7 });
	}

	@Test
	public void canRemoveElementFromList() {
		assertTrue(list.isEmpty());

		list.insert(5);
		list.insert(6);
		list.insert(7);

		assertFalse(list.isEmpty());

		assertTrue(list.delete(6));
		assertArrayEquals(list.toArray().toArray(), new Object[] { 5, 7 });

		assertTrue(list.delete(5));
		assertArrayEquals(list.toArray().toArray(), new Object[] { 7 });
	}

	@Test
	public void cantRemoveElementThatsNotThere() {
		assertTrue(list.isEmpty());

		list.insert(5);

		assertFalse(list.isEmpty());

		assertFalse(list.delete(6));
		assertArrayEquals(list.toArray().toArray(), new Object[] { 5 });
	}

	@Test
	public void cantInsertElementThatsAlreadyThere() {
		assertTrue(list.isEmpty());

		assertTrue(list.insert(5));

		assertFalse(list.isEmpty());

		assertFalse(list.delete(6));
		assertArrayEquals(list.toArray().toArray(), new Object[] { 5 });
	}
}
