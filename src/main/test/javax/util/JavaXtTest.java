package javax.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JavaXtTest {

	ListXt<Integer> l;
	ListXt<Integer> e;

	@BeforeEach
	public void setUp() {
		Integer[] array = new Integer[] { 3, 10, -2, 1, 7, 6, 6, 15 };
		l = new ArrayListXt<>(array);
		e = new ArrayListXt<>();
	}

	@Test
	public void testAllMatch() {
		assertTrue(l.allMatch(x -> x instanceof Integer));
		assertTrue(e.allMatch(x -> x instanceof Integer));
	}

	@Test
	public void testAnyMatch() {
		assertTrue(l.anyMatch(x -> x > -2));
		assertTrue(l.anyMatch(x -> x < -1));
	}

	@Test
	public void testNoneMatch() {
		assertTrue(l.noneMatch(x -> x > 100));
		assertTrue(e.noneMatch(x -> x > 100));
	}

	@Test
	public void testFind() {
		assertEquals(10, l.find(x -> x > 6));
		assertNull(l.find(x -> x > 100));
		assertNull(e.find(x -> x > 0));
	}

	@Test
	public void testFindIndex() {
		assertEquals(1, l.findIndex(x -> x > 6));
		assertEquals(-1, l.findIndex(x -> x > 100));
		assertEquals(-1, e.findIndex(x -> x > 0));
	}

	@Test
	public void testFilter() {
		ListXt<Integer> filtered = l.filter(x -> x > 1);
		assertNotNull(filtered);
		assertEquals(6, filtered.size());

		filtered = e.filter(x -> x > 1);
		assertNotNull(filtered);
		assertEquals(0, filtered.size());
	}

	@Test
	public void testMap() {
		ListXt<Integer> mapped = l.map(x -> x + 1);
		assertNotNull(mapped);
		assertEquals(8, mapped.size());
		assertEquals(-1, mapped.get(2));

		mapped = e.map(x -> x + 1);
		assertNotNull(mapped);
		assertEquals(0, mapped.size());
	}

	@Test
	public void testDistinct() {
		ListXt<Integer> distinct = l.distinct();
		assertNotNull(distinct);
		assertEquals(7, distinct.size());

		distinct = e.distinct();
		assertNotNull(distinct);
		assertEquals(0, distinct.size());
	}

	@Test
	public void testMax() {
		assertEquals(15, l.max());
		assertNull(e.max());
	}

	@Test
	public void testMin() {
		assertEquals(-2, l.min());
		assertNull(e.min());
	}

	@Test
	public void testSorted() {
		Integer[] arrayOrdered = new Integer[] { -2, 1, 3, 6, 6, 7, 10, 15 };
		ListXt<Integer> expected = new ArrayListXt<>(arrayOrdered);
		ListXt<Integer> sorted = l.sorted();
		assertEquals(expected, sorted);

		sorted = e.distinct();
		assertNotNull(sorted);
		assertEquals(0, sorted.size());
	}

	@Test
	public void testSum() {
		assertEquals(46, l.sum());
		assertEquals(0, e.sum());
	}

	@Test
	public void testMul() {
		assertEquals(-226800, l.mul());
		assertEquals(1, e.mul());
	}

	@Test
	public void testAvg() {
		assertEquals(5.75, l.avg());
	}

	@Test
	public void testSigma() {
		double expected = 13.9821;
		double sigma = l.sigma();
		assertTrue(Math.abs(sigma - expected) < 0.001);
	}

	@Test
	public void testNorm() {
		double expected = 21.4476;
		double norm = l.norm();
		assertTrue(Math.abs(norm - expected) < 0.001);
	}
}
