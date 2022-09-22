package javax.util;

import java.util.Collection;
import java.util.LinkedList;

public class LinkedListXt2<E> extends LinkedList<E> implements ListXt<E> {

	private static final long serialVersionUID = 7312232377125183306L;

	public LinkedListXt2() {
		super();
	}

	public LinkedListXt2(Collection<? extends E> elements) {
		super(elements);
	}

}
