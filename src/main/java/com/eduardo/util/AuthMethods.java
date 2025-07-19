package com.eduardo.util;

import java.util.Collection;
import java.util.Objects;

public final class AuthMethods {
	
	public static final void isNull(Object o) {
		if (o == null)
			throw new RuntimeException("Parameter is null");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static final <T extends Collection> void removeNulls(T o) {
		isNull(o);
		o.removeIf(Objects::isNull);
	}

}
