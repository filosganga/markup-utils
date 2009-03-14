package com.filosganga.utils.markup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @author Filippo De Luca
 * @version $Id$
 */
@Test(groups = "unit")
public class BufferUtilsUnitTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BufferUtilsUnitTest.class);

	
	public void ensureSpaceBeforeStringBuilderMustLeaveEmpty() {
		
		StringBuilder buffer = new StringBuilder();
		BufferUtils.ensureSpaceBefore(buffer);
		
		String msg = new StringBuilder("Expected: 0, ").append(" Found: ").append(buffer.length()).toString();
		logger.info(msg);
		
		assert buffer.length() == 0 : msg;
	}

	public void ensureSpaceBeforeStringBuilderMustAddSpace() {
		
		StringBuilder buffer = new StringBuilder();
		buffer.append("fooString");
		
		BufferUtils.ensureSpaceBefore(buffer);
		
		int testLenght = buffer.length();
		String lenghtMsg = new StringBuilder("Expected: ").append("fooString".length() + 1).append(" Found: ").append(testLenght).toString();
		logger.info(lenghtMsg);
		assert testLenght == "fooString".length() + 1 : lenghtMsg;
		
		String testValue = buffer.substring(buffer.length() - 1);
		String valueMsg = new StringBuilder("Expected: ").append(" (space)").append(" Found: ").append(testValue).toString();
		logger.info(valueMsg);
		
		assert " ".equals(testValue) : valueMsg;
	}
	
	public void ensureSpaceBeforeStringBufferMustLeaveEmpty() {
		
		StringBuffer buffer = new StringBuffer();
		BufferUtils.ensureSpaceBefore(buffer);
		
		String msg = new StringBuilder("Expected: 0, ").append(" Found: ").append(buffer.length()).toString();
		logger.info(msg);
		
		assert buffer.length() == 0 : msg;
	}

	public void ensureSpaceBeforeStringBufferMustAddSpace() {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("fooString");
		
		BufferUtils.ensureSpaceBefore(buffer);
		
		int testLenght = buffer.length();
		String lenghtMsg = new StringBuilder("Expected: ").append("fooString".length() + 1).append(" Found: ").append(testLenght).toString();
		logger.info(lenghtMsg);
		assert testLenght == "fooString".length() + 1 : lenghtMsg;
		
		String testValue = buffer.substring(buffer.length() - 1);
		String valueMsg = new StringBuilder("Expected: ").append(" (space)").append(" Found: ").append(testValue).toString();
		logger.info(valueMsg);
		
		assert " ".equals(testValue) : valueMsg;
	}

	public void ensureSemicolonBeforeStringBuilderMustLeaveEmpty() {
		
		StringBuilder buffer = new StringBuilder();
		BufferUtils.ensureSemicolonBefore(buffer);
			
		String msg = new StringBuilder("Expected: 0, ").append(" Found: ").append(buffer.length()).toString();
		logger.info(msg);
		
		assert buffer.length() == 0 : msg;
	}
	
	public void ensureSemicolonBeforeStringBufferMustLeaveEmpty() {
		
		StringBuffer buffer = new StringBuffer();
		BufferUtils.ensureSemicolonBefore(buffer);
			
		String msg = new StringBuilder("Expected: 0, ").append(" Found: ").append(buffer.length()).toString();
		logger.info(msg);
		
		assert buffer.length() == 0 : msg;
	}

	public void ensureSemicolonBeforeStringBuilderMustLeaveAsIs() {
		
		StringBuilder buffer = new StringBuilder();
		buffer.append("fooString;");
		BufferUtils.ensureSemicolonBefore(buffer);
			
		String lengthMsg = new StringBuilder("Expected: ").append("fooString;".length()).append(" Found: ").append(buffer.length()).toString();
		logger.info(lengthMsg);
		assert buffer.length() == "fooString;".length() : lengthMsg;
		

		String valueMsg = new StringBuilder("Expected: ").append("fooString;".length()).append(" Found: ").append(buffer.length()).toString();
		logger.info(valueMsg);
		assert "fooString;".equals(buffer.toString()) : valueMsg;

	}
	
	public void ensureSemicolonBeforeStringBufferMustLeaveAsIs() {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("fooString;");
		BufferUtils.ensureSemicolonBefore(buffer);
			
		String lengthMsg = new StringBuilder("Expected: ").append("fooString;".length()).append(" Found: ").append(buffer.length()).toString();
		logger.info(lengthMsg);
		assert buffer.length() == "fooString;".length() : lengthMsg;
		

		String valueMsg = new StringBuilder("Expected: ").append("fooString;".length()).append(" Found: ").append(buffer.length()).toString();
		logger.info(valueMsg);
		assert "fooString;".equals(buffer.toString()) : valueMsg;
	}

	public void ensureSemicolonBeforeStringBuilderMustAddSemicolon() {
		
		StringBuilder buffer = new StringBuilder();
		buffer.append("fooString");
		
		BufferUtils.ensureSemicolonBefore(buffer);
		
		int testLenght = buffer.length();
		String lenghtMsg = new StringBuilder("Expected: ").append("fooString".length() + 1).append(" Found: ").append(testLenght).toString();
		logger.info(lenghtMsg);
		assert testLenght == "fooString".length() + 1 : lenghtMsg;
		
		String testValue = buffer.substring(buffer.length() - 1);
		String valueMsg = new StringBuilder("Expected: ").append("fooString").append(";").append(" Found: ").append(testValue).toString();
		logger.info(valueMsg);
		
		assert ";".equals(testValue) : valueMsg;
	}
	
	public void ensureSemicolonBeforeStringBufferMustAddSemicolon() {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("fooString");
		
		BufferUtils.ensureSemicolonBefore(buffer);
			
		int testLenght = buffer.length();
		String lenghtMsg = new StringBuilder("Expected: ").append("fooString".length() + 1).append(" Found: ").append(testLenght).toString();
		logger.info(lenghtMsg);
		assert testLenght == "fooString".length() + 1 : lenghtMsg;
		
		String testValue = buffer.substring(buffer.length() - 1);
		String valueMsg = new StringBuilder("Expected: ").append("fooString").append(";").append(" Found: ").append(testValue).toString();
		logger.info(valueMsg);
		assert ";".equals(testValue) : valueMsg;
	}

}
