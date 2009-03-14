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

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
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

	private final StringBuilder buffer;
	
	public CssStyleBuilder() {
		buffer = new StringBuilder();
	}
	
	public CssStyleBuilder appendProperty(String name, Object value){
		
		String valueText = ObjectUtils.toString(value);
		
		if(StringUtils.isNotBlank(valueText)){
			if(buffer.length()>0 && !buffer.substring(buffer.length()-1).equals(";")){
				buffer.append(";");
			}
			buffer.append(name).append(":").append(valueText);
		}
		
		return this;
	}
	
	public CssStyleBuilder appendStyle(String style){
		
		if(StringUtils.isNotBlank(style)){
			if(buffer.length()>0 && !buffer.substring(buffer.length()-1).equals(";")){
				buffer.append(";");
			}
			buffer.append(style);
		}
		
		return this;
	}
	
	public CssStyleBuilder openSelector(String selector){
		
		if(StringUtils.isNotBlank(selector)){
			buffer.append(selector).append(" {\n");
		}
		
		return this;
	}
	
	public CssStyleBuilder closeSelector(){
		
		buffer.append("}\n");
		
		return this;
	}
	
	public String toCssStyle(){
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
		
		builder.appendSuper(obj instanceof CssStyleBuilder);
		if(builder.isEquals()){
			CssStyleBuilder other = (CssStyleBuilder)obj;
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
