package controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MissingLetters {
	public String getMissingLetters(String sentence) {
		List<String> items = Arrays.asList(removeDuplicateString(sentence.toLowerCase()).replaceAll("[^A-Za-z]+", "")
				.replaceAll("\\s", "").split("(?!^)"));
		Collections.sort(items, String.CASE_INSENSITIVE_ORDER);
		List<String> alphabet = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
				"p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
		Collection<String> equalsLetters = new HashSet<String>(items);
		Collection<String> notEqualsLetters = new HashSet<String>();
		notEqualsLetters.addAll(items);
		notEqualsLetters.addAll(alphabet);
		equalsLetters.retainAll(alphabet);
		notEqualsLetters.removeAll(equalsLetters);
		String missingLetters = "";
		for (String str : notEqualsLetters) {
			missingLetters += str;
		}
		return missingLetters;
	}

	public static String removeDuplicateString(final String input) {
		final Set<Character> set = new LinkedHashSet<>();
		for (int i = 0; i < input.length(); i++)
			set.add(input.charAt(i));
		final StringBuilder stringBuilder = new StringBuilder(set.size());
		for (final Character character : set)
			stringBuilder.append(character);
		return stringBuilder.toString();
	}

}
