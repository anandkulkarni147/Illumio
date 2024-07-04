package org.illumio;

import java.util.Map;
import java.util.Set;

/**
 * Main Application class
 */
public class Main {
    public static void main(String[] args) {
        // Load predefined words from predefined_words input file
        Set<String> predefinedWords = PredefinedWordsLoader.loadPredefinedWords();

        // Match file against predefined set of words
        Map<String, Integer> matchCounts = MatchCounter.countMatches(predefinedWords);

        System.out.printf("%-25s %s%n", "Predefined word", "Match count");
        matchCounts.entrySet().forEach(entry -> System.out.printf("%-25s %d%n", entry.getKey(), entry.getValue()));
    }
}