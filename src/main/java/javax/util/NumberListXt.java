package javax.util;

import java.util.Iterator;

/**
 * This is essentially a vector of numbers, so we can perform typical algebraic
 * and statistical operations. Notice that this is not intended as a real math
 * library; performance is quite bad.
 * 
 * @author luca vercelli 2022
 *
 */
public interface NumberListXt extends ListXt<Number> {

	/**
	 * Sum list elements.
	 * 
	 * @return sum of elements, and in particular 0 if list is empty
	 */
	default double sum() {
		double current = 0;
		for (Number element : this) {
			current += element.doubleValue();
		}
		return current;
	}

	/**
	 * Multiply list elements.
	 * 
	 * @return sum of elements, and in particular 1 if list is empty
	 */
	default double mul() {
		double current = 1;
		for (Number element : this) {
			current *= element.doubleValue();
		}
		return current;
	}

	/**
	 * Vector norm.
	 * 
	 * @return norm of vector, and in particular 0 if list is empty
	 * @throws <code>ClassCastException</code> if elements are not
	 * <code>Number</code>'s
	 */
	default double norm() {
		double current = 0;
		for (Number element : this) {
			double x = element.doubleValue();
			current += x * x;
		}
		return Math.sqrt(current);
	}

	/**
	 * Average of list elements.
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
	 * Return standard deviation of this list.
	 * 
	 * @return standard deviation of list
	 * @throws <code>IllegalArgumentException</code> if list is empty
	 */
	default double sigma() {
		double avg = avg();
		double current = 0;
		for (Number element : this) {
			double x = element.doubleValue() - avg;
			current += x * x;
		}
		return Math.sqrt(current);
	}

	/**
	 * Scalar multiplication of two vectors.
	 * 
	 * @return scalar multiplication of given vectors
	 * @throws <code>IllegalArgumentException</code> if the two lists have different
	 * size
	 */
	default double mul(ListXt<Number> other) {
		if (size() != other.size())
			throw new IllegalArgumentException("Cannot multiply vectors of different size");
		double current = 0;
		Iterator<Number> it = other.iterator();
		for (Number x : this) {
			Number y = it.next();
			current += x.doubleValue() * y.doubleValue();
		}
		return current;
	}

	/**
	 * Multiply this vector by a scalar value.
	 * 
	 * @return new list
	 */
	default NumberListXt scalarMul(Number other) {
		NumberListXt l = new NumberArrayListXt(size());
		for (Number element : this) {
			l.add(other.doubleValue() * element.doubleValue());
		}
		return l;
	}

	/**
	 * Sum two vectors pairwise.
	 * 
	 * @return new list
	 * @throws <code>IllegalArgumentException</code> if the two lists have different
	 * size
	 */
	default NumberListXt sumPairwise(NumberListXt other) {
		if (size() != other.size())
			throw new IllegalArgumentException("Cannot sum vectors of different size");
		NumberListXt l = new NumberArrayListXt(size());
		Iterator<Number> it = other.iterator();
		for (Number element : this) {
			Number y = it.next();
			l.add(y.doubleValue() + element.doubleValue());
		}
		return l;
	}

	/**
	 * Multiply two vectors pairwise.
	 * 
	 * @return new list
	 * @throws <code>IllegalArgumentException</code> if the two lists have different
	 * size
	 */
	default NumberListXt mulPairwise(NumberListXt other) {
		if (size() != other.size())
			throw new IllegalArgumentException("Cannot multiply vectors of different size");
		NumberListXt l = new NumberArrayListXt(size());
		Iterator<Number> it = other.iterator();
		for (Number element : this) {
			Number y = it.next();
			l.add(y.doubleValue() * element.doubleValue());
		}
		return l;
	}
}
