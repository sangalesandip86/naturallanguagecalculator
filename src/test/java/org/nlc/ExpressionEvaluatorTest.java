package org.nlc;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * 
 * @author sandip.p.sangale
 *
 */
@RunWith(Parameterized.class)
public class ExpressionEvaluatorTest {
	private String inputExpression;
	private double expectedResult;
	private ExpressionEvaluator expressionEvaluation;

	@Before
	public void initialize() {
		expressionEvaluation = new ExpressionEvaluator();
	}

	public ExpressionEvaluatorTest(String inputExpression, double expectedResult) {
		this.inputExpression = inputExpression;
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Object primeNumbers() {
		return Arrays.asList(new Object[][] { { "9/8+4*2/3", 3.79 }, { "1+6", 7 }, { "1+2*3", 7 }, { "9-3*7", -12 },
				{ "4-8+6*9", 50 }, { "7/9+2", 2.78 } });
	}

	@Test
	public void testEvaluation() {
		assertEquals(expectedResult, expressionEvaluation.evaluate(inputExpression), 0.1);
	}
}
