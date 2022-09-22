package javax.util;

import java.util.Collection;

public class NumberLinkedList extends LinkedListXt<Number> implements NumberListXt {

	private static final long serialVersionUID = 8135630540372015813L;

	public NumberLinkedList() {
		super();
	}

	public NumberLinkedList(Collection<? extends Number> elements) {
		super(elements);
	}

	public NumberLinkedList(Number[] elements) {
		super(elements);
	}

}
