package javax.util;

import java.util.Collection;

public class NumberArrayListXt extends ArrayListXt<Number> implements NumberListXt {

	private static final long serialVersionUID = -5312520008862797486L;

	public NumberArrayListXt() {
		super();
	}

	public NumberArrayListXt(Collection<? extends Number> elements) {
		super(elements);
	}

	public NumberArrayListXt(Number[] elements) {
		super(elements);
	}

	public NumberArrayListXt(int initialCapacity) {
		super(initialCapacity);
	}

}
