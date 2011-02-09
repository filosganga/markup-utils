/**
 * This file is part of MarkupUtils.
 *
 * MarkupUtils is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MarkupUtils is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with MarkupUtils.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (c) 2009 Filippo De Luca
 */

package com.googlecode.markuputils;

import java.io.IOException;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

/**
 * This Static class collects some methods useful to build CSS.
 * 
 * @author Filippo De Luca
 * @version $Id$
 */
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
