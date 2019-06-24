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
			return leftVal + evaluate(expression);
		} else {
			return leftVal - evaluate(expression);
		}

	}

	private double getNextOperand(String[] exp) {
		double res;
		if (exp[0].startsWith("(")) {
			int open = 1;
			int i = 1;
			while (open != 0) {
				if (exp[0].charAt(i) == '(') {
					open++;
				} else if (exp[0].charAt(i) == ')') {
					open--;
				}
				i++;
			}
			res = evaluate(exp[0].substring(1, i - 1));
			exp[0] = exp[0].substring(i);
		} else {
			int i = 1;
			if (exp[0].charAt(0) == '-') {
				i++;
			}
			while (exp[0].length() > i && isNumber((int) exp[0].charAt(i))) {
				i++;
			}
			res = Double.parseDouble(exp[0].substring(0, i));
			exp[0] = exp[0].substring(i);
		}
		return res;
	}

	private static boolean isNumber(int c) {
		int zero = (int) '0';
		int nine = (int) '9';
		return (c >= zero && c <= nine) || c == '.';
	}

}
