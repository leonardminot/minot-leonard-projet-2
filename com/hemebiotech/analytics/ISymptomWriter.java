package com.hemebiotech.analytics;

import java.util.Map;


/**
 * Anything that will write symptom data from a Map to a file.
 *
 */
public interface ISymptomWriter {
    /**
     * Write a Map of symptoms into an external file : "result.out"
     *
     * @param symptoms Map of all the symptoms as keys and the occurrence as value
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}
