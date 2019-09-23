package com.garfield.testmybatisplus.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * WordUtils 字符串工具类
 */
public class WordUtils {
	private static final Pattern CHINESE_PATTERN = Pattern.compile("[\u4e00-\u9fa5]");
	private static final Pattern CAMEL_TO_UNDERLINE_PATTERN = Pattern.compile("[A-Z]([a-z\\d]+)?");
	private static final Pattern UNDERLINE_TO_CAMEL_PATTERN = Pattern.compile("([A-Za-z\\d]+)(_)?");
    private static final String HOTWORDS_PATTERN = "[\u4e00-\u9fa5]+";

	/**
	 * 判断字符串是否为数字
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			int chr = str.charAt(i);
			if (chr < 48 || chr > 57) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断字符串中是否包含中文
	 * @param str 待校验字符串
	 * @return 是否为中文
	 * @warn 不能校验是否为中文标点符号
	 */

	public static boolean isContainChinese(String str) {
		Matcher m = CHINESE_PATTERN.matcher(str);
		if (m.find()) {
			return true;
		}
		return false;
	}

	/**
	 * 下划线转驼峰法
	 * @param line 源字符串
	 * @param smallCamel 大小驼峰,是否为小驼峰
	 * @return 转换后的字符串
	 */
	public static String underline2Camel(String line, boolean smallCamel) {
		if (line == null || "".equals(line)) {
			return "";
		}
		StringBuffer sb = new StringBuffer();

		Matcher matcher = UNDERLINE_TO_CAMEL_PATTERN.matcher(line);
		while (matcher.find()) {
			String word = matcher.group();
			sb.append(smallCamel && matcher.start() == 0 ? Character.toLowerCase(word.charAt(0))
					: Character.toUpperCase(word.charAt(0)));
			int index = word.lastIndexOf('_');
			if (index > 0) {
				sb.append(word.substring(1, index).toLowerCase());
			}
			else {
				sb.append(word.substring(1).toLowerCase());
			}
		}
		return sb.toString();
	}

	/**
	 * 驼峰法转下划线
	 * @param line 源字符串
	 * @return 转换后的字符串
	 */
	public static String camel2Underline(String line) {
		if (line == null || "".equals(line)) {
			return "";
		}

		boolean isLowerCase = true;
		char[] chars = line.toCharArray();
		for (char c : chars) {
			isLowerCase = isLowerCase && Character.isLowerCase(c);
			if (!isLowerCase) {
				break;
			}
		}
		if (isLowerCase) {
			return line;
		}
		line = String.valueOf(line.charAt(0)).toUpperCase().concat(line.substring(1));
		StringBuilder sb = StringBuilderUtils.get();
		Matcher matcher = CAMEL_TO_UNDERLINE_PATTERN.matcher(line);
		while (matcher.find()) {
			String word = matcher.group();
			sb.append(word.toUpperCase());
			sb.append(matcher.end() == line.length() ? "" : "_");
		}
		return sb.toString();
	}

    /**
     * 判断是否是中文
     */
    public static boolean isChinese(String hotWords) {
        return Pattern.matches(HOTWORDS_PATTERN, hotWords);
    }
}
