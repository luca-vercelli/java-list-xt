package javax.util;

import java.util.Iterator;

public interface NumberListXt<E extends Number> extends ListXt<E> {

	/**
	 * Sum a list of <code>Number</code>'s.
	 * 
	 * @return sum of elements, and in particular 0 if list is empty
	 */
	default double sum() {
		double current = 0;
		for (E element : this) {
			current += element.doubleValue();
		}
		return current;
	}

	/**
	 * Multiplies a list of <code>Number</code>'s.
	 * 
	 * @return sum of elements, and in particular 1 if list is empty
	 */
	default double mul() {
		double current = 1;
		for (E element : this) {
			current *= element.doubleValue();
		}
		return current;
	}

	/**
	 * Return a mathematical norm for this list of <code>Number</code>'s.
	 * 
	 * @return norm of elements, and in particular 0 if list is empty
	 * @throws <code>ClassCastException</code> if elements are not
	 * <code>Number</code>'s
	 */
	default double norm() {
		double current = 0;
		for (E element : this) {
			double x = element.doubleValue();
			current += x * x;
		}
		return Math.sqrt(current);
	}

	/**
	 * Average of elements of this list of <code>Number</code>'s.
	 * 
	 * @return avg of elements
	 * @throws <code>IllegalArgumentException</code> if list is empty
	 */
	default double avg() {
		if (isEmpty())
			throw new IllegalArgumentException("Cannot calculate average of empty list");
		return sum() / size();
	}

	/**
	 * Return standard deviation of this list of <code>Number</code>'s.
	 * 
	 * @return standard deviation of list
	 * @throws <code>IllegalArgumentException</code> if list is empty
	 */
	default double sigma() {
		double avg = avg();
		double current = 0;
		for (E element : this) {
			double x = element.doubleValue() - avg;
			current += x * x;
		}
		return Math.sqrt(current);
	}

	/**
	 * Multiplies a list of <code>Number</code>'s.
	 * 
	 * @return sum of elements, and in particular 1 if list is empty
	 * @throws <code>IllegalArgumentException</code> if the two lists have different
	 * size
	 */
	default double mul(ListXt<E> other) {
		if (size() != other.size())
			throw new IllegalArgumentException("Cannot multiply vectors of different size");
		double current = 0;
		Iterator<E> it = other.iterator();
		for (E x : this) {
			E y = it.next();
			current += x.doubleValue() * y.doubleValue();
		}
		return current;
	}
}
