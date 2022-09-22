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

}
