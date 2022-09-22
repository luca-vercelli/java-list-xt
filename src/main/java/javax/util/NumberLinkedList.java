package javax.util;

import java.util.Collection;

public class NumberLinkedList<E extends Number> extends LinkedListXt<E> implements NumberListXt<E> {

	private static final long serialVersionUID = 8135630540372015813L;

	public NumberLinkedList() {
		super();
	}

	public NumberLinkedList(Collection<? extends E> elements) {
		super(elements);
	}

	public NumberLinkedList(E[] elements) {
		super(elements);
	}

}
