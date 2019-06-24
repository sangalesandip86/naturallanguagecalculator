package org.nlc;

/**
 * @author sandip.p.sangale
 *
 */
public class ExpressionEvaluation {
	/**
	 * This method evaluates Mathematical expression provided in String format and
	 * return result in numeric format
	 * 
	 * @param expression
	 * @return
	 */
	public Double evaluate(String expression) {

		if (expression.startsWith("(") && expression.endsWith(")")) {
			return evaluate(expression.substring(1, expression.length() - 1));
		}
		String[] containerArr = new String[] { expression };
		double leftVal = getNextOperand(containerArr);
		expression = containerArr[0];
		if (expression.length() == 0) {
			return leftVal;
		}
		char operator = expression.charAt(0);
		expression = expression.substring(1);

		while (operator == '*' || operator == '/') {
			containerArr[0] = expression;
			double rightVal = getNextOperand(containerArr);
			expression = containerArr[0];
			if (operator == '*') {
				leftVal = leftVal * rightVal;
			} else {
				leftVal = leftVal / rightVal;
			}
			if (expression.length() > 0) {
				operator = expression.charAt(0);
				expression = expression.substring(1);
			} else {
				return leftVal;
			}
		}
		if (operator == '+') {
			if (leftVal < 0) {
				return evaluate(expression) - leftVal;
			}
			return leftVal + evaluate(expression);
		} else {
			return leftVal - evaluate(expression);
		}

	}

	private double getNextOperand(String[] exp) {
		double res;
		int i = 1;
		res = Double.parseDouble(exp[0].substring(0, i));
		exp[0] = exp[0].substring(i);
		return res;
	}
}
