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

}
