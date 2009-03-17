/*
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

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.Validate;

/**
 * This Static class collects some methods useful to build HTML like markup
 * 
 * @author Filippo De Luca
 * @version $Id$
 */
public final class MarkupUtils {

	public static void startOpenElement(StringBuilder buffer, String name) {

		if (StringUtils.isNotBlank(name)) {
			buffer.append("<").append(name);
		}
	}

	public static void startOpenElement(StringBuffer buffer, String name) {

		if (StringUtils.isNotBlank(name)) {
			buffer.append("<").append(name);
		}
	}

	public static void endOpenElement(StringBuilder buffer) {

		buffer.append(">");
	}

	public static void endOpenElement(StringBuffer buffer) {

		buffer.append(">");
	}

	public static void openElement(StringBuilder buffer, String name) {

		if (StringUtils.isNotBlank(name)) {
			buffer.append("<").append(name).append(">");
		}
	}

	public static void openElement(StringBuffer buffer, String name) {

		if (StringUtils.isNotBlank(name)) {
			buffer.append("<").append(name).append(">");
		}
	}

	public static void closeElement(StringBuilder buffer, String name) {

		if (StringUtils.isNotBlank(name)) {
			buffer.append("</").append(name).append(">");
		}
	}

	public static void closeElement(StringBuffer buffer, String name) {

		if (StringUtils.isNotBlank(name)) {
			buffer.append("</").append(name).append(">");
		}
	}

	public static void openCloseElement(StringBuilder buffer, String name) {

		if (StringUtils.isNotBlank(name)) {
			buffer.append("<").append(name).append("/>");
		}
	}

	public static void openCloseElement(StringBuffer buffer, String name) {

		if (StringUtils.isNotBlank(name)) {
			buffer.append("<").append(name).append("/>");
		}
	}

	public static void endOpenCloseElement(StringBuilder buffer) {

		buffer.append("/>");
	}

	public static void endOpenCloseElement(StringBuffer buffer) {

		buffer.append("/>");
	}

	public static void appendText(StringBuilder buffer, String text) {

		if (StringUtils.isNotEmpty(text)) {
			buffer.append(text);
		}
	}

	public static void appendText(StringBuffer buffer, String text) {

		if (StringUtils.isNotEmpty(text)) {
			buffer.append(text);
		}
	}

	public static void appendNewLine(StringBuilder buffer) {

		buffer.append(SystemUtils.LINE_SEPARATOR);
	}

	public static void appendNewLine(StringBuffer buffer) {

		buffer.append(SystemUtils.LINE_SEPARATOR);
	}

	public static void appendAttribute(StringBuilder buffer, String name,
			Object value) {

		Validate.notNull(buffer, "buffer must be not null");

		String valueString = ObjectUtils.toString(value);

		if (StringUtils.isNotBlank(valueString)) {
			BufferUtils.ensureSpaceBefore(buffer);
			buffer.append(name).append("=\"").append(valueString).append("\"");
		}

	}

	public static void appendAttribute(StringBuffer buffer, String name,
			Object value) {

		Validate.notNull(buffer, "buffer must be not null");

		String valueString = ObjectUtils.toString(value);

		if (StringUtils.isNotBlank(valueString)) {
			BufferUtils.ensureSpaceBefore(buffer);
			buffer.append(name).append("=\"").append(valueString).append("\"");
		}

	}

	/**
	 * Writes a comment on the given StringBuilder.
	 * 
	 * @param buffer The StringBuilder used to write comment.
	 * @param comment The comment to write.
	 */
	public static void appendComment(StringBuilder buffer, String comment) {
		buffer.append("<!-- ").append(comment).append(" -->");
	}

	/**
	 * Writes a comment on the given StringBuffer.
	 * 
	 * @param buffer The StringBuffer used to write comment.
	 * @param comment The comment to write.
	 */
	public static void appendComment(StringBuffer writer, String comment) {
		writer.append("<!-- ").append(comment).append(" -->");
	}

}
