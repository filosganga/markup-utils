package com.googlecode.markuputils;

import java.io.IOException;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

public final class CssStyleUtils {

	private CssStyleUtils() {
		// Do not instantiate
	}

	public static String appendProperty(String name, Object value) {

		StringBuilder buffer = new StringBuilder();

		String valueText = ObjectUtils.toString(value);

		if (StringUtils.isNotBlank(valueText)) {
			buffer.append(name).append(":").append(valueText).append(";");
		}

		return buffer.toString();
	}

	public static String appendStyle(String style) {

		StringBuilder buffer = new StringBuilder();

		if (StringUtils.isNotBlank(style)) {
			buffer.append(style);
		}

		return buffer.toString();
	}

	public static String openSelector(String selector) {

		StringBuilder buffer = new StringBuilder();

		if (StringUtils.isNotBlank(selector)) {
			buffer.append(selector).append(" {");
		}

		return buffer.toString();
	}

	public static String closeSelector() {
		return "}";
	}

	public static <T extends Appendable & CharSequence> void ensureSemicolonBefore(T buffer) {

		if (buffer.length() > 0	&& !buffer.subSequence(buffer.length() - 1, buffer.length()).equals(";")) {
			try {
				buffer.append(";");
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public static <T extends Appendable & CharSequence> void ensureSpaceBefore(T buffer) {
		if (buffer.length() > 0	&& !buffer.subSequence(buffer.length() - 1, buffer.length()).equals(" ")) {
			try {
				buffer.append(" ");
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
