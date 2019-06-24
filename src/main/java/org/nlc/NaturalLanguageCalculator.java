package org.nlc;

import java.util.Scanner;

import org.nlc.common.NaturalLanguageDictionary;
/**
 * Main class to execute expression,
 * It process mathematical expression given in natural language form.
 * 
 * @author sandip.p.sangale
 *
 */
public class NaturalLanguageCalculator {

	private static InputProcessor inputProcessor = new InputProcessor();
	private static NaturalLanguageDictionary naturalLanguageDictionary = new NaturalLanguageDictionary();
	private static ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean isValid = false;
		do {
			printMessage("Enter Expression : ");
			String naturalExpression = scanner.nextLine();
			isValid = inputProcessor.validate(naturalExpression);
			if (isValid) {
				String mathsExpression = naturalLanguageDictionary.convertNCLToMathsExpression(naturalExpression);
				printMessage(mathsExpression);
				Double result = expressionEvaluation.evaluate(mathsExpression);
				printMessage("Result : " + result);
			} else {
				printMessage("Invalid Expression");
			}
		} while (!isValid);
		scanner.close();
	}

	private static void printMessage(String message) {
		System.out.println(message);
	}
}
