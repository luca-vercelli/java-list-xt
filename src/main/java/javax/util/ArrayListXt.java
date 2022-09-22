package javax.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ArrayListXt<E> extends ArrayList<E> implements ListXt<E> {

	private static final long serialVersionUID = 679576903847576505L;

	public ArrayListXt() {
		super();
	}

	public ArrayListXt(Collection<? extends E> elements) {
		super(elements);
	}

	public ArrayListXt(E[] elements) {
		super(Arrays.asList(elements));
	}

	public ArrayListXt(int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 * Create a list of n equal elements
	 * 
	 * @param element
	 * @param n
	 * @return
	 */
	public static <E> ArrayListXt<E> sequence(E element, int n) {
		ArrayListXt<E> l = new ArrayListXt<E>(n);
		for (int i = 0; i < n; ++i) {
			l.add(element);
		}
		return l;
	}

}
