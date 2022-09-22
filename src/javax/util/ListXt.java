package javax.util;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * A List with methods from Stream interface.
 * 
 * @author luca vercelli 2022
 *
 * @param <E>
 */
public interface ListXt<E> extends List<E> {

	/**
	 * Returns whether all elements of this list match the provided predicate. May
	 * not evaluate the predicate on all elements if not necessary for determining
	 * the result. If the list is empty then true is returned and the predicate is
	 * not evaluated.
	 * 
	 * @param predicate a non-interfering, stateless predicate to apply to elements
	 *                  of this list
	 * @return true if either all elements of the list match the provided predicate
	 *         or the list is empty, otherwise false
	 * 
	 */
	default boolean allMatch(Predicate<? super E> predicate) {
		for (E element : this)
			if (!predicate.test(element))
				return false;
		return true;
	}

	/**
	 * Returns whether any elements of this list match the provided predicate. May
	 * not evaluate the predicate on all elements if not necessary for determining
	 * the result. If the list is empty then false is returned and the predicate is
	 * not evaluated.
	 * 
	 * @param predicate a non-interfering, stateless predicate to apply to elements
	 *                  of this list
	 * @return true if any elements of the list match the provided predicate,
	 *         otherwise false
	 */
	default boolean anyMatch(Predicate<? super E> predicate) {
		for (E element : this)
			if (predicate.test(element))
				return true;
		return false;
	}

	/**
	 * Returns whether no elements of this list match the provided predicate. May
	 * not evaluate the predicate on all elements if not necessary for determining
	 * the result. If the list is empty then true is returned and the predicate is
	 * not evaluated.
	 * 
	 * @param predicate a non-interfering, stateless predicate to apply to elements
	 *                  of this list
	 * @return true if either no elements of the list match the provided predicate
	 *         or the list is empty, otherwise false
	 * 
	 */
	default boolean noneMatch(Predicate<? super E> predicate) {
		return !anyMatch(predicate);
	}

	/**
	 * Returns a list consisting of the distinct elements (according to
	 * Object.equals(Object)) of this list.
	 * 
	 * @return the new list
	 */
	default ListXt<E> distinct() {
		Set<E> set = new HashSet<E>(this);
		return new ArrayListXt<>(set);
	}

	/**
	 * Returns a list consisting of the elements of this list that match the given
	 * predicate.
	 * 
	 * @param predicate a non-interfering, stateless predicate to apply to each
	 *                  element to determine if it should be included
	 * @return the new list
	 */
	default ListXt<E> filter(Predicate<? super E> predicate) {
		ListXt<E> l = new ArrayListXt<>();
		for (E element : this)
			if (predicate.test(element))
				l.add(element);
		return l;
	}

	/**
	 * Returns the first element matching given predicate.
	 * 
	 * @param predicate a non-interfering, stateless predicate to apply to each
	 *                  element to determine if it should be included
	 * @return first element, or null if not found.
	 */
	default E find(Predicate<? super E> predicate) {
		for (E element : this)
			if (predicate.test(element))
				return element;
		return null;
	}

	/**
	 * Returns the index of the first element matching given predicate.
	 * 
	 * @param predicate a non-interfering, stateless predicate to apply to each
	 *                  element to determine if it should be included
	 * @return index of first element, or -1 if not found.
	 */
	default int findIndex(Predicate<? super E> predicate) {
		int i = 0;
		for (E element : this) {
			if (predicate.test(element))
				return i;
			++i;
		}
		return -1;
	}

	/**
	 * Performs a reduction on the elements of this stream, using an associative
	 * accumulation function, and returns an Optional describing the reduced value,
	 * if any.
	 * 
	 * @param accumulator an associative, non-interfering, stateless function for
	 *                    combining two values
	 * @return the result of the reduction, or null if list is empty
	 */
	default E reduce(BinaryOperator<E> accumulator) {
		boolean first = true;
		E current = null;
		for (E element : this) {
			if (first) {
				first = false;
				current = element;
			} else {
				current = accumulator.apply(current, element);
			}
		}
		return current;

	}

	/**
	 * Returns a list consisting of the results of applying the given function to
	 * the elements of this list.
	 * 
	 * @param <R>
	 * @param mapper a non-interfering, stateless function to apply to each element
	 * @return the new list
	 */
	default <R> ListXt<R> map(Function<? super E, ? extends R> mapper) {
		ListXt<R> l = new ArrayListXt<>();
		for (E element : this)
			l.add(mapper.apply(element));
		return l;
	}

	/**
	 * Returns the maximum element of this list according to the provided
	 * <code>Comparator</code>
	 * 
	 * @param comparator a non-interfering, stateless <code>Comparator</code> to
	 *                   compare elements of this list
	 * @return the maximum element of this list, or null if the list is empty
	 */
	default E max(Comparator<? super E> comparator) {
		boolean first = true;
		E current = null;
		for (E element : this) {
			if (first) {
				first = false;
				current = element;
			} else {
				if (comparator.compare(element, current) > 0)
					current = element;
			}
		}
		return current;
	}

	/**
	 * Returns the minimum element of this list according to the provided
	 * <code>Comparator</code>.
	 * 
	 * @param comparator a non-interfering, stateless <code>Comparator</code> to
	 *                   compare elements of this list
	 * @return the minimum element of this list, or null if the list is empty
	 */
	default E min(Comparator<? super E> comparator) {
		boolean first = true;
		E current = null;
		for (E element : this) {
			if (first) {
				first = false;
				current = element;
			} else {
				if (comparator.compare(element, current) < 0)
					current = element;
			}
		}
		return current;
	}

	/**
	 * Returns the maximum element of this list according to their natural order.
	 * 
	 * @return the maximum element of this list, or null if the list is empty
	 * @throws <code>ClassCastException</code> if elements are not Comparable
	 */
	default E max() {
		boolean first = true;
		E current = null;
		for (E element : this) {
			if (first) {
				first = false;
				current = element;
			} else {
				if (!(element instanceof Comparable))
					throw new ClassCastException("Non Comparable class: " + element.getClass());
				@SuppressWarnings("unchecked")
				Comparable<E> c = (Comparable<E>) element;
				if (c.compareTo(current) > 0)
					current = element;
			}
		}
		return current;
	}

	/**
	 * Returns the minimum element of this list according to their natural order.
	 * 
	 * @return the minimum element of this list, or null if the list is empty
	 * @throws <code>ClassCastException</code> if elements are not Comparable
	 */
	default E min() {
		boolean first = true;
		E current = null;
		for (E element : this) {
			if (first) {
				first = false;
				current = element;
			} else {
				if (!(element instanceof Comparable))
					throw new ClassCastException("Non Comparable class: " + element.getClass());
				@SuppressWarnings("unchecked")
				Comparable<E> c = (Comparable<E>) element;
				if (c.compareTo(current) < 0)
					current = element;
			}
		}
		return current;
	}

	/**
	 * Returns a list consisting of the elements of this list, sorted according to
	 * natural order. If the elements of this list are not Comparable, a
	 * <code>ClassCastException</code> may be thrown when the terminal operation is
	 * executed.
	 * 
	 * @return the new list
	 */
	default ListXt<E> sorted() {
		// naive algorithm
		ListXt<E> l = new LinkedListXt2<>();
		for (E element : this) {
			if (!(element instanceof Comparable))
				throw new ClassCastException("Non Comparable class: " + element.getClass());
			@SuppressWarnings("unchecked")
			Comparable<E> x = (Comparable<E>) element;
			int index = 0;
			for (E y : l) {
				if (x.compareTo(y) > 0) {
					break;
				}
				++index;
			}
			l.add(index, element);
		}
		return l;
	}

	/**
	 * Returns a list consisting of the elements of this list, sorted according to
	 * the provided <code>Comparator</code>.
	 * 
	 * @param comparator a non-interfering, stateless <code>Comparator</code> to be
	 *                   used to compare list elements
	 * @return the new list
	 */
	default ListXt<E> sorted(Comparator<? super E> comparator) {
		// naive algorithm
		ListXt<E> l = new LinkedListXt2<>();
		for (E x : this) {
			int index = 0;
			for (E y : l) {
				if (comparator.compare(x, y) > 0) {
					break;
				}
				++index;
			}
			l.add(index, x);
		}
		return l;
	}

	/**
	 * Sum a list of Number's.
	 * 
	 * @return sum of elements, and in particular 0 if list is empty
	 * @throws <code>ClassCastException</code> if elements are not
	 * <code>Number</code>'s
	 */
	default double sum() {
		double current = 0;
		for (E element : this) {
			if (!(element instanceof Number))
				throw new ClassCastException("Non Number class: " + element.getClass());
			current += ((Number) element).doubleValue();
		}
		return current;
	}

	/**
	 * Multiplies a list of Number's.
	 * 
	 * @return sum of elements, and in particular 1 if list is empty
	 * @throws <code>ClassCastException</code> if elements are not
	 * <code>Number</code>'s
	 */
	default double mul() {
		double current = 1;
		for (E element : this) {
			if (!(element instanceof Number))
				throw new ClassCastException("Non Number class: " + element.getClass());
			current *= ((Number) element).doubleValue();
		}
		return current;
	}
}
