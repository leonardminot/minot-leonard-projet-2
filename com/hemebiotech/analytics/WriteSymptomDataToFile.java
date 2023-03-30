package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    public WriteSymptomDataToFile() {

    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("result.out", false));

            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}