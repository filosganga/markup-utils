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
 * Copyright (c) 2009 MobileFaces
 */
package com.filosganga.utils.markup;

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
	
	
	public MarkupBuilder startOpenElement(String name){
		
		if(StringUtils.isNotBlank(name)){
			buffer.append("<").append(name);
		}
		
		return this;
	}

	public MarkupBuilder endOpenElement(){
		
		buffer.append(">");
		
		return this;
	}

	public MarkupBuilder openElement(String name){
		
		if(StringUtils.isNotBlank(name)){
			buffer.append("<").append(name).append(">");
		}
		
		return this;
	}

	public MarkupBuilder closeElement(String name){

		if(StringUtils.isNotBlank(name)){
			buffer.append("</").append(name).append(">");
		}
		
		return this;
	}

	public MarkupBuilder openCloseElement(String name){
		
		if(StringUtils.isNotBlank(name)){
			buffer.append("<").append(name).append("/>");
		}
		return this;
	}

	public MarkupBuilder endOpenCloseElement(){
		
		buffer.append("/>");
		
		return this;
	}
	
	public MarkupBuilder appendText(String text){
		
		if(StringUtils.isNotEmpty(text)){
			buffer.append(text);
		}
		
		return this;
	}
	
	public MarkupBuilder appendNewLine(){
		
		buffer.append(SystemUtils.LINE_SEPARATOR);

		return this;
	}

	public MarkupBuilder appendAttribute(String name, String value){
		
		if(StringUtils.isNotBlank(value)){
			if(buffer.length()!=0 && !buffer.substring(buffer.length()-1, buffer.length()).equalsIgnoreCase(" ")){
				buffer.append(" ");
			}
			buffer.append(name).append("=\"").append(value).append("\"");
		}
		
		return this;
	}
	
    /**
     * Append a comment
     *
     * @param comment to append
     */
    public MarkupBuilder appendComment(String comment) {
    	
    	if(StringUtils.isNotBlank(comment)){   		
    		buffer.append("<!-- ").append(comment).append(" -->");
    	}
    	
    	return this;
    	
    }

	public String toMarkup(){
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
		if(builder.isEquals()){
			MarkupBuilder other = (MarkupBuilder)obj;
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
