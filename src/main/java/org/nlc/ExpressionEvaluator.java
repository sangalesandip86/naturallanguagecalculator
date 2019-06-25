package org.nlc;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sandip.p.sangale
 *
 */
public class ExpressionEvaluator {
	/**
	 * This method evaluates Mathematical expression provided in String format and
	 * return result in numeric format
	 * 
	 * @param expression
	 * @return
	 */
	public double evaluate(String expression) {
		Deque<Integer> op = new LinkedList<>();
		Deque<Double> val = new LinkedList<>();
		Deque<Integer> optmp = new LinkedList<>();
		Deque<Double> valtmp = new LinkedList<>();
		expression = expression.replaceAll("-", "+-");
		String temp = "";
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (ch == '-')
				temp = "-" + temp;
			else if (ch != '+' && ch != '*' && ch != '/')
				temp = temp + ch;
			else {
				val.push(Double.parseDouble(temp));
				op.push((int) ch);
				temp = "";
			}
		}
		val.push(Double.parseDouble(temp));
		char operators[] = { '/', '*', '+' };

		for (int i = 0; i < 3; i++) {
			boolean it = false;
			while (!op.isEmpty()) {
				int optr = op.pop();
				double v1 = val.pop();
				double v2 = val.pop();
				if (optr == operators[i]) {
					if (i == 0) {
						valtmp.push(v2 / v1);
						it = true;
						break;
					} else if (i == 1) {
						valtmp.push(v2 * v1);
						it = true;
						break;
					} else if (i == 2) {
						valtmp.push(v2 + v1);
						it = true;
						break;
					}
				} else {
					valtmp.push(v1);
					val.push(v2);
					optmp.push(optr);
				}
			}
			while (!valtmp.isEmpty())
				val.push(valtmp.pop());
			while (!optmp.isEmpty())
				op.push(optmp.pop());
			if (it)
				i--;
		}
		return val.pop();
	}
}
