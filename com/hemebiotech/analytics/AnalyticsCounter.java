package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Manages input and output files, transforming raw data into a usable and ordered set
 */
public class AnalyticsCounter {

	private final ISymptomReader symptomReader;
	private final ISymptomWriter symptomWriter;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		symptomReader = reader;
		symptomWriter = writer;
	}

	public List<String> getSymptoms() {
		return symptomReader.getSymptoms();
	}

	/**
	 * Count symptoms from a list with duplication
	 *
	 * @param symptoms List of all occurrences for each symptom (one line per occurrence)
	 * @return TreeMap with symptom as key and occurrences as value
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		final Map<String, Integer> symptomCounter = new TreeMap<>();

		for (String symptom : symptoms) {
			symptomCounter.putIfAbsent(symptom, 0);
			symptomCounter.put(symptom, symptomCounter.get(symptom) + 1);
		}
		return symptomCounter;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return symptoms;
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		symptomWriter.writeSymptoms(symptoms);
	}
}