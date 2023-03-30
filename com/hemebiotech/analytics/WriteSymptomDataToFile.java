package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    //private final static String FILE_PATH = "result.out";
    public void writeSymptoms(Map<String, Integer> symptoms) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("result.out", false));

            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }

            //writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}