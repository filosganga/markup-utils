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
package org.filippodeluca.markuputils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = "unit")
public class MarkupBuilderUnitTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MarkupBuilderUnitTest.class);

	public void markupBuilder() {
		MarkupBuilder builder = new MarkupBuilder();
		
		assert builder != null;
	}

	@Test(dataProvider = "elements", dependsOnMethods = {"markupBuilder"})
	public void openElement(String element) {
		String expected = "<" + element + ">";
		MarkupBuilder builder = new MarkupBuilder();

		builder.openElement(element);
		String testValue = builder.toMarkup();
		
		String msg = new StringBuilder().append("Expected: ").append(expected).append(", Found: ").append(testValue).toString();
		logger.info(msg);
		
		assert StringUtils.equals(expected, testValue) : msg;
	}

	@Test(dataProvider = "elements", dependsOnMethods = {"markupBuilder"})
	public void startOpenElement(String element) {
		String expected = "<" + element;
		MarkupBuilder builder = new MarkupBuilder();

		builder.startOpenElement(element);
		String testValue = builder.toMarkup();
		
		String msg = new StringBuilder().append("Expected: ").append(expected).append(", Found: ").append(testValue).toString();
		logger.info(msg);
		
		assert StringUtils.equals(expected, testValue) : msg;
	}

	@Test(dataProvider = "elements", dependsOnMethods={"markupBuilder", "startOpenElement"})
	public void endOpenElement(String element) {
		String expected = "<" + element + ">";
		
		MarkupBuilder builder = new MarkupBuilder();

		builder.startOpenElement(element);
		builder.endOpenElement();
		String testValue = builder.toMarkup();
		
		String msg = new StringBuilder().append("Expected: ").append(expected).append(", Found: ").append(testValue).toString();
		logger.info(msg);
		
		assert StringUtils.equals(expected, testValue) : msg;
	}

	@Test(dataProvider = "elements", dependsOnMethods={"markupBuilder", "startOpenElement"})
	public void endOpenCloseElement(String element) {
		String expected = "<" + element + "/>";
		
		MarkupBuilder builder = new MarkupBuilder();

		builder.startOpenElement(element);
		builder.endOpenCloseElement();
		String testValue = builder.toMarkup();
		
		String msg = new StringBuilder().append("Expected: ").append(expected).append(", Found: ").append(testValue).toString();
		logger.info(msg);
		
		assert StringUtils.equals(expected, testValue) : msg;
	}

	@Test(dataProvider = "elements", dependsOnMethods = {"markupBuilder"})
	public void closeElement(String element) {
		String expected = "</" + element + ">";
		MarkupBuilder builder = new MarkupBuilder();

		builder.closeElement(element);
		String testValue = builder.toMarkup();
		
		String msg = new StringBuilder().append("Expected: ").append(expected).append(", Found: ").append(testValue).toString();
		logger.info(msg);
		
		assert StringUtils.equals(expected, testValue) : msg;
	}
	
	@Test(dataProvider = "elements", dependsOnMethods = {"markupBuilder"})
	public void openCloseElement(String element) {
		String expected = "<" + element + "/>";
		MarkupBuilder builder = new MarkupBuilder();

		builder.openCloseElement(element);
		String testValue = builder.toMarkup();
		
		String msg = new StringBuilder().append("Expected: ").append(expected).append(", Found: ").append(testValue).toString();
		logger.info(msg);
		
		assert StringUtils.equals(expected, testValue) : msg;
	}
	
	@Test(dataProvider = "attributes", dependsOnMethods={"markupBuilder", "startOpenElement", "endOpenCloseElement"})
	public void appendAttribute(String name, String value) {
		final String element = "div";
		String expected = null;
		
		StringBuilder expectedBuilder = new StringBuilder();
		expectedBuilder.append("<").append(element);
		if(StringUtils.isNotBlank(value)){
			expectedBuilder.append(" ").append(name).append("=\"").append(value).append("\"");
		}
		expectedBuilder.append("/>");
		
		expected = expectedBuilder.toString();
		
		MarkupBuilder builder = new MarkupBuilder();

		builder.startOpenElement(element);
		builder.appendAttribute(name, value);
		builder.endOpenCloseElement();
		
		String testValue = builder.toMarkup();
		
		String msg = new StringBuilder().append("Expected: ").append(expected).append(", Found: ").append(testValue).toString();
		logger.info(msg);
		
		assert StringUtils.equals(expected, testValue) : msg;
	}
	
	@Test(dataProvider = "texts", dependsOnMethods={"markupBuilder"})
	public void appendText(String text) {
		
		String expected = StringUtils.EMPTY;
		
		// Can contains '\t', '\n' and ' '
		if(StringUtils.isNotEmpty(text)) {
			expected = new String(text);
		}
		
		MarkupBuilder builder = new MarkupBuilder();
		builder.appendText(text);		
		
		String testValue = builder.toMarkup();
		
		String msg = new StringBuilder().append("Expected: ").append(expected).append(", Found: ").append(testValue).toString();
		logger.info(msg);
		
		assert StringUtils.equals(expected, testValue) : msg;
	}

	
	@DataProvider(name = "elements")
	public Object[][] getElements() {
		return new Object[][]{
				{"a"},
				{"p"},
				{"div"},
				{"li"},
				{"ol"},
				// ...
		};
	}

	@DataProvider(name = "attributes")
	public Object[][] getAttributes() {
		return new Object[][]{
				{"class","myclass"},
				{"class", "   "},
				{"class", ""},
				{"class", "\t"},
				{"class", "\n"},
				{"class", null},
				// ...
		};

	}

	@DataProvider(name = "texts")
	public Object[][] getTexts() {
		return new Object[][]{
				{"Foo foo foo"},
				{"\t"},
				{"\n"},
				{"  "},
				{""},
				{null},
				// ...
		};
	}


}
