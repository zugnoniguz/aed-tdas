package aed.ut3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackTest {
	private Stack<Integer> stack;

	@BeforeEach
	void init() {
		stack = new Stack<>();
	}

	@Test
	void emptyStackIsEmpty() {
		assertTrue(stack.isEmpty());
	}

	@Test
	void canAddElementToStack() {
		assertTrue(stack.isEmpty());

		stack.push(5);
		stack.push(3);
		stack.push(6);

		assertFalse(stack.isEmpty());
	}

	@Test
	void canPopElementToStack() {
		assertTrue(stack.isEmpty());

		stack.push(5);
		stack.push(3);
		stack.push(6);

		assertFalse(stack.isEmpty());

		assertEquals(stack.peek().intValue(), 6);
		assertEquals(stack.pop().intValue(), 6);
		assertEquals(stack.peek().intValue(), 3);
		assertEquals(stack.pop().intValue(), 3);
		assertEquals(stack.peek().intValue(), 5);
		assertEquals(stack.pop().intValue(), 5);

		assertTrue(stack.isEmpty());
	}

	@Test
	void canEmptyStack() {
		assertTrue(stack.isEmpty());

		stack.push(5);
		stack.push(3);
		stack.push(6);

		assertFalse(stack.isEmpty());

		stack.empty();

		assertTrue(stack.isEmpty());
	}
}
