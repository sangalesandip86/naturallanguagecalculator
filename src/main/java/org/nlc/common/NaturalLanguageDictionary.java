package org.nlc.common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nlc.exceptions.InvalidExpressionException;

/**
 * 
 * This class contain methods to provide vocabulary of operators and numbers allowed in expression.
 * 
 * @author sandip.p.sangale
 *
 */
public class NaturalLanguageDictionary {
	private static final String BLANK = "";
	private static final String DIVIDE_OPERATOR = "/";
	private static final String MULTIPLY_OPERATOR = "*";
	private static final String MINUS_OPERATOR = "-";
	private static final String ADD_OPERATOR = "+";
	private static final String EXPRESSION_IS_NULL = "Expression is NULL";

	/**
	 * This method returns numbers vocabulary
	 * 
	 * @return
	 */
	public Map<String, String> getNumbersVocabulary() {
		HashMap<String, String> numbersMapping = new HashMap<>();
		numbersMapping.put("one", "1");
		numbersMapping.put("two", "2");
		numbersMapping.put("three", "3");
		numbersMapping.put("four", "4");
		numbersMapping.put("five", "5");
		numbersMapping.put("six", "6");
		numbersMapping.put("seven", "7");
		numbersMapping.put("eight", "8");
		numbersMapping.put("nine", "9");
		numbersMapping.put("ten", "10");
		return numbersMapping;
	}

	/**
	 * 
	 * @param expression
	 * @return
	 */
	public String convertNCLToMathsExpression(String expression) {
		if (expression == null) {
			throw new InvalidExpressionException(EXPRESSION_IS_NULL);
		}
		expression = convertWordOperatorsToOperator(expression);
		expression = expression.replaceAll("\\s+", BLANK);
		return convertWordsToNumbers(expression);
	}

	/**
	 * 
	 * @param expression
	 * @return
	 */
	private String convertWordsToNumbers(String expression) {
		for (Map.Entry<String, String> entry : getNumbersVocabulary().entrySet()) {
			expression = expression.replaceAll(entry.getKey(), entry.getValue());
		}
		return expression;
	}

	private String convertWordOperatorsToOperator(String expression) {
		for (Map.Entry<String, List<String>> entry : getOperatorsVocabulary().entrySet()) {
			List<String> value = entry.getValue();
			for (String operator : value) {
				expression = expression.replaceAll(operator, entry.getKey());
			}
		}
		return expression;
	}

	/**
	 * This method returns the operator's natural language vocabulary allowed in
	 * expression
	 * 
	 * @return
	 */
	public Map<String, List<String>> getOperatorsVocabulary() {
		Map<String, List<String>> operatorsMapping = new HashMap<>();
		List<String> addition = Arrays.asList("add", "plus");
		List<String> substraction = Arrays.asList("subtract", "minus", "less");
		List<String> multiply = Arrays.asList("multiplied-by", "times");
		List<String> divide = Arrays.asList("divided-by", "over");

		operatorsMapping.put(ADD_OPERATOR, addition);
		operatorsMapping.put(MINUS_OPERATOR, substraction);
		operatorsMapping.put(MULTIPLY_OPERATOR, multiply);
		operatorsMapping.put(DIVIDE_OPERATOR, divide);
		return operatorsMapping;
	}
}
