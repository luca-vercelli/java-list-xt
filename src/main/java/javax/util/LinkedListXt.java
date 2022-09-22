package javax.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public class LinkedListXt<E> extends LinkedList<E> implements ListXt<E> {

	private static final long serialVersionUID = 7312232377125183306L;

	public LinkedListXt() {
		super();
	}

	public LinkedListXt(Collection<? extends E> elements) {
		super(elements);
	}

	public LinkedListXt(E[] elements) {
		super(Arrays.asList(elements));
	}

	/**
	 * Create a list of n equal elements
	 * 
	 * @param element
	 * @param n
	 * @return
	 */
	public static <E> LinkedListXt<E> sequence(E element, int n) {
		LinkedListXt<E> l = new LinkedListXt<E>();
		for (int i = 0; i < n; ++i) {
			l.add(element);
		}
		return l;
	}

}
