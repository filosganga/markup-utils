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

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * This class is intended helping to build HTML like markup.
 * 
 * @author Filippo De Luca
 * @version $Id$
 */
public class MarkupBuilder implements Serializable {

	private static final long serialVersionUID = 10L;

	private final StringBuilder buffer;

	public MarkupBuilder() {
		buffer = new StringBuilder();
	}

	/**
	 * Start open element, appending &quot;&lt;&quot; plus element name.
	 * <p>
	 * Ex: &quot;&lt;div&quot;
	 * </p>
	 * 
	 * @param name
	 *            The name of the element to start
	 * @return a reference to this builder.
	 */
	public MarkupBuilder startOpenElement(String name) {

		if (StringUtils.isNotBlank(name)) {
			buffer.append("<").append(name);
		}

		return this;
	}

	/**
	 * End open element appending &quot;&gt;&quot;.
	 * <p>
	 * Ex: &quot;&gt;&quot;
	 * </p>
	 * 
	 * @return a reference to this builder.
	 */
	public MarkupBuilder endOpenElement() {

		buffer.append(">");

		return this;
	}

	/**
	 * Opens element, appending &quot;&lt;&quot;, element name and
	 * &quot;&gt;&quot;.
	 * <p>
	 * Ex: &quot;&lt;div&gt&quot;.
	 * </p>
	 * 
	 * @param name
	 *            The name of the element to open
	 * @return a reference to this builder.
	 */
	public MarkupBuilder openElement(String name) {

		if (StringUtils.isNotBlank(name)) {
			buffer.append("<").append(name).append(">");
		}

		return this;
	}

	/**
	 * Closes element, appending &quot;&lt;/&quot;, element name and
	 * &quot;&gt;&quot;.
	 * <p>
	 * Ex: &quot;&lt;/div&gt&quot;.
	 * </p>
	 * 
	 * @param name
	 *            The name of the element to close
	 * @return a reference to this builder.
	 */
	public MarkupBuilder closeElement(String name) {

		if (StringUtils.isNotBlank(name)) {
			buffer.append("</").append(name).append(">");
		}

		return this;
	}

	/**
	 * Append open-close element, appending &quot;&lt;&quot;, element name and
	 * &quot;/&gt;&quot;.
	 * <p>
	 * Ex: &quot;&lt;div/&gt&quot;.
	 * </p>
	 * 
	 * @param name
	 *            The name of the element to append
	 * @return a reference to this builder.
	 */
	public MarkupBuilder openCloseElement(String name) {

		if (StringUtils.isNotBlank(name)) {
			buffer.append("<").append(name).append("/>");
		}
		return this;
	}

	/**
	 * Ends open-close element, appending &quot;/&gt;&quot;.
	 * <p>
	 * Ex: &quot;/&gt&quot;.
	 * </p>
	 * 
	 * @return a reference to this builder.
	 */
	public MarkupBuilder endOpenCloseElement() {

		buffer.append("/>");

		return this;
	}

	/**
	 * Appends text to this builder.
	 * 
	 * @param text
	 *            The text to append.
	 * @return a reference to this builder.
	 */
	public MarkupBuilder appendText(String text) {

		if (StringUtils.isNotEmpty(text)) {
			buffer.append(text);
		}

		return this;
	}

	/**
	 * Appends new line to this builder.
	 * 
	 * @return a reference to this builder.
	 */
	public MarkupBuilder appendNewLine() {

		buffer.append(SystemUtils.LINE_SEPARATOR);

		return this;
	}

	/**
	 * Appends attribute to started element. If the attribute value is blank,
	 * the builder does nothing.
	 * <p>
	 * Ex: class=&quot;foo&quot;
	 * <p>
	 * 
	 * @param name The name of attribute to append.
	 * @param value The value of attribute to append.
	 * @return a reference to this builder.
	 */
	public MarkupBuilder appendAttribute(String name, String value) {

		if (StringUtils.isNotBlank(value)) {
			BufferUtils.ensureSpaceBefore(buffer);
			buffer.append(name).append("=\"").append(value).append("\"");
		}

		return this;
	}

	/**
	 * Append a comment.
	 * <p>
	 * Ex: &lt;!-- comment --&gt;
	 * 
	 * @param comment The comment to append.
	 * @return a reference to this builder.
	 */
	public MarkupBuilder appendComment(String comment) {

		if (StringUtils.isNotBlank(comment)) {
			buffer.append("<!-- ").append(comment).append(" -->");
		}

		return this;

	}

	/**
	 * Return the generated markup.
	 * 
	 * @return Generated markup.
	 */
	public String toMarkup() {
		return buffer.toString();
	}

	// Commons methods ****************************************************

	@Override
	public String toString() {

		return toMarkup();
	}

	@Override
	public boolean equals(Object obj) {
		EqualsBuilder builder = new EqualsBuilder();

		builder.appendSuper(obj instanceof MarkupBuilder);
		if (builder.isEquals()) {
			MarkupBuilder other = (MarkupBuilder) obj;
			builder.append(buffer, other.buffer);
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
