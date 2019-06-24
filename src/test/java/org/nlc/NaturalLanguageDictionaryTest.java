package org.nlc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.nlc.common.NaturalLanguageDictionary;
import org.nlc.exceptions.InvalidExpressionException;

/**
 * 
 * @author sandip.p.sangale
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class NaturalLanguageDictionaryTest {

	private NaturalLanguageDictionary naturalLanguageDictionary = new NaturalLanguageDictionary();

	@Test(expected = InvalidExpressionException.class)
	public void testNullExpressionConversion() {
		// Given
		String expression = null;
		// When
		naturalLanguageDictionary.convertNCLToMathsExpression(expression);
	}

	@Test
	public void testConvertNCLToMathsExpression() {
		// Given
		String expression = "nine over eight plus four times two divided-by three";
		String expectedExpression = "9/8+4*2/3";

		// When
		String actualExpression = naturalLanguageDictionary.convertNCLToMathsExpression(expression);
		// Then
		assertEquals(expectedExpression, actualExpression);
	}

	@Test
	public void testCapitalSmallCombination() {
		// Given
		String expression = "ONE over EighT";
		String expectedExpression = "1/8";

		// When
		String actualExpression = naturalLanguageDictionary.convertNCLToMathsExpression(expression);
		// Then
		assertEquals(expectedExpression, actualExpression);
	}
}
