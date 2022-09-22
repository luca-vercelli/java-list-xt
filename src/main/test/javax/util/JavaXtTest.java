package javax.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JavaXtTest {

	ListXt<Integer> l = new ArrayListXt<>();
	ListXt<Integer> e = new ArrayListXt<>();

	@BeforeEach
	public void setUp() {
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(3);
	}

	@Test
	public void testAllMatch() {
		assertTrue(l.allMatch(x -> x instanceof Integer));
		assertTrue(e.allMatch(x -> x instanceof Integer));
	}

	@Test
	public void testAnyMatch() {
		assertTrue(l.anyMatch(x -> x > 2));
		assertTrue(l.anyMatch(x -> x < 2));
	}

	@Test
	public void testNoneMatch() {
		assertTrue(l.noneMatch(x -> x > 10));
		assertTrue(e.noneMatch(x -> x > 10));
	}

	@Test
	public void testFind() {
		assertEquals(2, l.find(x -> x > 1));
		assertNull(l.find(x -> x > 10));
		assertNull(e.find(x -> x > 0));
	}

	@Test
	public void testFindIndex() {
		assertEquals(1, l.findIndex(x -> x > 1));
		assertEquals(-1, l.findIndex(x -> x > 10));
		assertEquals(-1, e.findIndex(x -> x > 0));
	}

	@Test
	public void testFilter() {
		ListXt<Integer> filtered = l.filter(x -> x > 1);
		assertNotNull(filtered);
		assertEquals(3, filtered.size());

		filtered = e.filter(x -> x > 1);
		assertNotNull(filtered);
		assertEquals(0, filtered.size());
	}

	@Test
	public void testMap() {
		ListXt<Integer> mapped = l.map(x -> x + 1);
		assertNotNull(mapped);
		assertEquals(4, mapped.size());
		assertEquals(4, mapped.get(2));

		mapped = e.map(x -> x + 1);
		assertNotNull(mapped);
		assertEquals(0, mapped.size());
	}
	
	@Test
	public void testSum() {
		assertEquals(9, l.sum());
		assertEquals(0, e.sum());
	}
	
	@Test
	public void testMul() {
		assertEquals(18, l.mul());
		assertEquals(1, e.mul());
	}
}
