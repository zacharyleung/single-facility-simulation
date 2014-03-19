package com.gly.sfs.util;

public abstract class MathUtils {
	public static int positiveModulo(int a, int b)
			throws IllegalArgumentException {
		if (b < 1) {
			throw new IllegalArgumentException("b >= 1 violated!");
		}
		return (a % b + b) % b;
	}
}
