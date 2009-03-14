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
package com.filosganga.utils.markup;

/**
 * @author Filippo De Luca
 * @version $Id$
 * 
 */
public final class BufferUtils {

	/**
	 * Ensure there is a space as last character in buffer, or the buffer is
	 * empty.
	 * 
	 * @param buffer
	 *            The StringBuilder to check.
	 */
	public static void ensureSpaceBefore(StringBuilder buffer) {
		if (buffer.length() > 0
				&& !buffer.substring(buffer.length() - 1).equals(" ")) {
			buffer.append(" ");
		}
	}

	/**
	 * Ensure there is a space as last character in buffer, or the buffer is
	 * empty.
	 * 
	 * @param buffer
	 *            The StringBuffer to check.
	 */
	public static void ensureSpaceBefore(StringBuffer buffer) {
		if (buffer.length() > 0
				&& !buffer.substring(buffer.length() - 1).equals(" ")) {
			buffer.append(" ");
		}
	}

	/**
	 * Ensure there is a semicolon(;) as last character in buffer, or the buffer
	 * is empty.
	 * 
	 * @param buffer
	 *            The StringBuffer to check.
	 */
	public static void ensureSemicolonBefore(StringBuilder buffer) {
		if (buffer.length() > 0
				&& !buffer.substring(buffer.length() - 1).equals(";")) {
			buffer.append(";");
		}
	}

	/**
	 * Ensure there is a semicolon(;) as last character in buffer, or the buffer
	 * is empty.
	 * 
	 * @param buffer
	 *            The StringBuilder to check.
	 */
	public static void ensureSemicolonBefore(StringBuffer buffer) {
		if (buffer.length() > 0
				&& !buffer.substring(buffer.length() - 1).equals(";")) {
			buffer.append(";");
		}
	}

}
