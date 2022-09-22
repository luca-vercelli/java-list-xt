package javax.util;

import java.util.Collection;

public class NumberArrayListXt<E extends Number> extends ArrayListXt<E> implements NumberListXt<E> {

	private static final long serialVersionUID = -5312520008862797486L;

	public NumberArrayListXt() {
		super();
	}

	public NumberArrayListXt(Collection<? extends E> elements) {
		super(elements);
	}

	public NumberArrayListXt(E[] elements) {
		super(elements);
	}

	public NumberArrayListXt(int initialCapacity) {
		super(initialCapacity);
	}

}
