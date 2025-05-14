package aed.ut3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueueTest {
	private Queue<Integer> queue;

	@BeforeEach
	void init() {
		queue = new Queue<>();
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
}
