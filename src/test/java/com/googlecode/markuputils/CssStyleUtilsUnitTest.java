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

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * @author Filippo De Luca
 * @version $Id$
 */
@Test
public class CssStyleUtilsUnitTest {
	
	public void ensureSpaceBeforeMustLeaveEmpty() {
		
		StringBuilder buffer = new StringBuilder();
		CssStyleUtils.ensureSpaceBefore(buffer);
		
		assertEquals(buffer.length(), 0);
	}

	public void ensureSpaceBeforeMustAddSpace() {
		
		StringBuilder buffer = new StringBuilder();
		buffer.append("fooString");
		
		CssStyleUtils.ensureSpaceBefore(buffer);

		assertEquals(buffer.length(), "fooString".length() + 1);
		
		assertEquals(buffer.substring(buffer.length() - 1), " ");
	}

	public void ensureSemicolonBeforeMustLeaveEmpty() {
		
		StringBuilder buffer = new StringBuilder();
		CssStyleUtils.ensureSemicolonBefore(buffer);
		
		assertEquals(buffer.length(), 0);
	}

	public void ensureSemicolonBeforeMustLeaveAsIs() {
		
		StringBuilder buffer = new StringBuilder();
		buffer.append("fooString;");
		CssStyleUtils.ensureSemicolonBefore(buffer);
			
		assertEquals(buffer.length(), "fooString;".length());
		
		assertEquals(buffer.toString(), "fooString;");

	}
	
	public void ensureSemicolonBeforeMustAddSemicolon() {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("fooString");
		
		CssStyleUtils.ensureSemicolonBefore(buffer);
		
		assertEquals(buffer.length(), "fooString".length() + 1);
	
		assertEquals(buffer.toString(), "fooString;");
	}
	

}
