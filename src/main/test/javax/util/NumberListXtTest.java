package javax.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumberListXtTest {

	NumberListXt<Integer> l;
	NumberListXt<Integer> e;

	@BeforeEach
	public void setUp() {
		Integer[] array = new Integer[] { 3, 10, -2, 1, 7, 6, 6, 15 };
		l = new NumberArrayListXt<>(array);
		e = new NumberArrayListXt<>();
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
	public void testMul2() {
		assertEquals(460, l.mul(l));
		assertEquals(0, e.mul(e));
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
