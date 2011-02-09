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

import java.io.IOException;

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

	private static <T extends Appendable & CharSequence> void append(T buffer, String appending) {
		
		Validate.notNull(buffer, "buffer cannot be null");
		
		try {
			buffer.append(appending);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	// No side effect methods *********************************************
	
	public static String startOpenElement(String name) {
		
		StringBuilder buffer = new StringBuilder();

		if (StringUtils.isNotBlank(name)) {
			buffer.append("<").append(name);
		}
		
		return buffer.toString();
	}
	
	public static String endOpenElement() {		
		return ">";
	}
	
	public static String openElement(String name) {
		
		StringBuilder buffer = new StringBuilder();

		if (StringUtils.isNotBlank(name)) {
			buffer.append("<").append(name).append(">");
		}
		
		return buffer.toString();
	}
	
	public static String closeElement(String name) {

		StringBuilder buffer = new StringBuilder();
		
		if (StringUtils.isNotBlank(name)) {
			buffer.append("</").append(name).append(">");
		}
		
		return buffer.toString();
	}
	
	public static String openCloseElement(String name) {
		
		StringBuilder buffer = new StringBuilder();

		if (StringUtils.isNotBlank(name)) {
			buffer.append("<").append(name).append("/>");
		}
		
		return buffer.toString();
	}

	public static String endOpenCloseElement() {
		return "/>";
	}

	public static String appendAttribute(String name, Object value) {

		StringBuilder buffer = new StringBuilder();

		String valueString = ObjectUtils.toString(value).trim();

		if (StringUtils.isNotBlank(valueString)) {
			buffer.append(" ").append(name).append("=\"").append(valueString).append("\"");
		}
		
		return buffer.toString();

	}
	
	public static String appendNullableAttribute(String name, Object value) {

		StringBuilder buffer = new StringBuilder();

		String valueString = ObjectUtils.toString(value).trim();
		
		if(StringUtils.isNotBlank(name)) {
			buffer.append(" ").append(name).append("=\"").append(valueString).append("\"");
		}
		
		return buffer.toString();
	}

	public static String appendComment(String comment) {
		
		StringBuilder buffer = new StringBuilder();
		
		if(StringUtils.isNotBlank(comment)) {
			buffer.append("<!-- ").append(comment).append(" -->");
		}
		
		return buffer.toString();
	}
	
	public static String appendText(String text) {
		
		if (StringUtils.isNotEmpty(text)) {
			return text;
		}
		else {
			return "";
		}
	}

	// Buffer methods *****************************************************
	
	public static <T extends Appendable & CharSequence> void startOpenElement(T buffer, String name) {
		
		append(buffer, startOpenElement(name));
	}

	public static <T extends Appendable & CharSequence> void endOpenElement(T buffer) {
		
		append(buffer, endOpenElement());
	}

	public static <T extends Appendable & CharSequence> void openElement(T buffer, String name) {
		
		append(buffer, openElement(name));
	}

	public static <T extends Appendable & CharSequence> void closeElement(T buffer, String name) {

		append(buffer, closeElement(name));
	}

	public static <T extends Appendable & CharSequence> void openCloseElement(T buffer, String name) {
		
		append(buffer, openCloseElement(name));
	}

	public static <T extends Appendable & CharSequence> void endOpenCloseElement(T buffer) {
		
		append(buffer, endOpenCloseElement());
	}

	public static <T extends Appendable & CharSequence> void appendAttribute(T buffer, String name, Object value) {

		append(buffer, appendAttribute(name, value));
	}

	public static <T extends Appendable & CharSequence> void appendNullableAttribute(T buffer, String name, Object value) {

		append(buffer, appendNullableAttribute(name, value));
	}

	public static <T extends Appendable & CharSequence> void appendComment(T buffer, String comment) {
		
		append(buffer, appendComment(comment));
	}
	
	public static <T extends Appendable & CharSequence> void appendText(T buffer, String text) {

		append(buffer, appendText(text));
	}
	
	/**
	 * 
	 * @deprecated It is useless.
	 */
	@Deprecated
	public static <T extends Appendable & CharSequence> void appendNewLine(T buffer) {

		Validate.notNull(buffer, "buffer cannot be null");
		
		append(buffer, SystemUtils.LINE_SEPARATOR);
	}
	
}
