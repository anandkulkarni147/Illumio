package org.illumio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.illumio.FilePaths.INPUT_FILE;

/**
 * Match predefined words against input file
 */
public class MatchCounter {

    public static Map<String, Integer> countMatches(Set<String> predefinedWords) {
        Map<String, Integer> matchCounts = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (predefinedWords.contains(word)) {
                        matchCounts.put(word, matchCounts.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matchCounts;
    }
}
