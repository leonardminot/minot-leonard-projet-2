package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile();
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        List<String> listOfSymptoms = analyticsCounter.getSymptoms();
        Map<String, Integer> symptomsOccurence = analyticsCounter.countSymptoms(listOfSymptoms);

        symptomsOccurence = analyticsCounter.sortSymptoms(symptomsOccurence);

        analyticsCounter.writeSymptoms(symptomsOccurence);
    }
}