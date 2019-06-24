package org.nlc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.nlc.common.NaturalLanguageDictionary;

/**
 * 
 * @author sandip.p.sangale
 *
 */
public class InputProcessor {
	private NaturalLanguageDictionary naturalLanguageDictionary = new NaturalLanguageDictionary();

	/**
	 * This methods check expression contain permitted words only
	 * 
	 * @param expression
	 * @return
	 */
	public boolean validate(String expression) {
		Set<String> vocabularySet = new HashSet<>();

		String[] splited = expression.toLowerCase().split("\\s+");
		Map<String, String> numbersVocab = this.naturalLanguageDictionary.getNumbersVocabulary();

		vocabularySet.addAll(numbersVocab.keySet());

		Map<String, List<String>> operatorsVocab = this.naturalLanguageDictionary.getOperatorsVocabulary();
		for (Map.Entry<String, List<String>> entry : operatorsVocab.entrySet()) {
			vocabularySet.addAll(entry.getValue());
		}

		return vocabularySet.containsAll(Arrays.asList(splited));
	}
}
