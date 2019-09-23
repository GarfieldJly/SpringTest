package com.garfield.testmybatisplus.util;

/**
 * StringBuilderUtils StringBuilderUtils
 */
public final class StringBuilderUtils {
	/**
	 * 线程单独的StringBuilder
	 */
	private static final ThreadLocal<StringBuilder> sbMap = new ThreadLocal<>();

	public static StringBuilder get() {
		StringBuilder sb = sbMap.get();
		if (sb == null) {
			sb = new StringBuilder();
			sbMap.set(sb);
		}
		sb.setLength(0);
		return sb;
	}

}
