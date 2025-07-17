package com.eduardo.util;

import java.util.Collection;
import java.util.Objects;

public class AuthMethods {
	
	public static void isNull(Object o) {
		if (o == null)
			throw new RuntimeException("Parameter is null");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T extends Collection> void removeNulls(T o) {
		isNull(o);
		o.removeIf(Objects::isNull);
	}

}
