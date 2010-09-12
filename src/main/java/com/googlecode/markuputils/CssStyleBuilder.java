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

import java.io.Serializable;

import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * This class is a builder for CSS style sheet.
 * 
 * @author Filippo De Luca
 * @version $Id$
 */
public class CssStyleBuilder implements Serializable {

	private static final long serialVersionUID = 10L;

	private final StringBuilder buffer = new StringBuilder();
	
	public CssStyleBuilder openSelector(String selector) {

		CssStyleUtils.ensureSpaceBefore(buffer);
		buffer.append(CssStyleUtils.openSelector(selector));

		return this;
	}

	public CssStyleBuilder appendProperty(String name, Object value) {

		buffer.append(CssStyleUtils.appendProperty(name, value));

		return this;
	}

	public CssStyleBuilder appendStyle(String style) {

		CssStyleUtils.ensureSemicolonBefore(buffer);
		buffer.append(CssStyleUtils.appendStyle(style));

		return this;
	}



	public CssStyleBuilder closeSelector() {

		buffer.append(CssStyleUtils.closeSelector());

		return this;
	}

	/**
	 * Appends new line to this builder.
	 * 
	 * @return a reference to this builder.
	 */
	public CssStyleBuilder appendNewLine() {

		buffer.append(SystemUtils.LINE_SEPARATOR);

		return this;
	}

	public String toCssStyle() {
		return buffer.toString();
	}

	// Commons methods ****************************************************

	@Override
	public String toString() {
		return toCssStyle();
	}

	@Override
	public boolean equals(Object obj) {
		EqualsBuilder builder = new EqualsBuilder();

		if (obj instanceof CssStyleBuilder) {
			CssStyleBuilder other = (CssStyleBuilder) obj;
			builder.append(buffer, other.buffer);
		}
		else {
			builder.appendSuper(false);
		}

		return builder.isEquals();
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();

		builder.append(getClass()).append(buffer);

		return builder.toHashCode();
	}

}
