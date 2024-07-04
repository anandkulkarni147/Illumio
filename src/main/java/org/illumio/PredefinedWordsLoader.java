package org.illumio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.illumio.FilePaths.PREDEFINED_WORDS_FILE;

/**
 * Load predefined words and trim them
 */
public class PredefinedWordsLoader {
    public static Set<String> loadPredefinedWords() {
        Set<String> words = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(PREDEFINED_WORDS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isEmpty() || line.length() == 0 || line.length() > 256) continue;
                words.add(line.toLowerCase().trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }
}
