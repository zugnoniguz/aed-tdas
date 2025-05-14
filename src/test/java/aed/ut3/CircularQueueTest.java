package aed.ut3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CircularQueueTest {
	private CircularQueue<Integer> queue;

	@BeforeEach
	void init() {
		queue = new CircularQueue<Integer>(5);
	}

	@Test
	void emptyStackIsEmpty() {
		assertTrue(queue.isEmpty());
	}

	@Test
	void canAddElementToStack() {
		assertTrue(queue.isEmpty());

		queue.push(5);
		queue.push(3);
		queue.push(6);

		assertFalse(queue.isEmpty());
	}

	@Test
	void canPopElementToStack() {
		assertTrue(queue.isEmpty());

		queue.push(5);
		queue.push(3);
		queue.push(6);

		assertFalse(queue.isEmpty());

		assertEquals(queue.front().intValue(), 5);
		assertEquals(queue.pop().intValue(), 5);
		assertEquals(queue.front().intValue(), 3);
		assertEquals(queue.pop().intValue(), 3);
		assertEquals(queue.front().intValue(), 6);
		assertEquals(queue.pop().intValue(), 6);

		assertTrue(queue.isEmpty());
	}

	@Test
	void canEmptyStack() {
		assertTrue(queue.isEmpty());

		queue.push(5);
		queue.push(3);
		queue.push(6);

		assertFalse(queue.isEmpty());

		queue.empty();

		assertTrue(queue.isEmpty());
	}

	@Test
	void wrapsAround() {
		assertTrue(queue.isEmpty());

		queue.push(5);
		queue.push(3);
		queue.push(6);
		queue.push(7);
		queue.push(8);

		assertEquals(queue.pop().intValue(), 5);
		assertEquals(queue.pop().intValue(), 3);
		queue.push(10);

		assertFalse(queue.isEmpty());

		assertEquals(queue.pop().intValue(), 6);
		assertEquals(queue.pop().intValue(), 7);
		assertEquals(queue.pop().intValue(), 8);
		assertEquals(queue.pop().intValue(), 10);
	}

	@Test
	void sizeWorks() {
		assertTrue(queue.isEmpty());

		queue.push(5);
		assertEquals(queue.size(), 1);
		queue.push(3);
		assertEquals(queue.size(), 2);
		queue.push(6);
		assertEquals(queue.size(), 3);
		queue.push(7);
		assertEquals(queue.size(), 4);
		queue.push(8);
		assertEquals(queue.size(), 5);

		assertEquals(queue.pop().intValue(), 5);
		assertEquals(queue.size(), 4);
		assertEquals(queue.pop().intValue(), 3);
		assertEquals(queue.size(), 3);
		queue.push(10);
		assertEquals(queue.size(), 4);

		assertFalse(queue.isEmpty());

		assertEquals(queue.pop().intValue(), 6);
		assertEquals(queue.size(), 3);
		assertEquals(queue.pop().intValue(), 7);
		assertEquals(queue.size(), 2);
		assertEquals(queue.pop().intValue(), 8);
		assertEquals(queue.size(), 1);
		assertEquals(queue.pop().intValue(), 10);
		assertEquals(queue.size(), 0);

		assertTrue(queue.isEmpty());
	}
}
