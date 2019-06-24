package org.nlc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
/**
 * 
 * @author sandip.p.sangale
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ExpressionEvaluationTest {

	private ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation();

	@Test
	public void testEvaluateAdd() {
		// Given
		String mathsExpression = "1+6";
		double expectedResult = 7;
		// When
		double actualResult = this.expressionEvaluation.evaluate(mathsExpression);
		// Then
		assertEquals(expectedResult, actualResult, 0);
	}

	@Test
	public void calculate_simple_expression_with_different_operator_priority() {
		assertEquals(7, expressionEvaluation.evaluate("1+2*3"), 0);
	}

	@Test
	public void calculate_one_number() {
		assertEquals(3, expressionEvaluation.evaluate("3"), 0);
	}

	@Test
	public void calculate_simple_expression() {
		assertEquals(5, expressionEvaluation.evaluate("3+2"), 0);
	}

	@Test
	public void calculate_simple_expression_with_all_operator() {
		assertEquals(3.79, expressionEvaluation.evaluate("9/8+4*2/3"), 0.1);
	}

	@Test
	public void calculate_simple_expression_with_negative_result() {
		assertEquals(-12, expressionEvaluation.evaluate("9-3*7"), 0.1);
	}

}
