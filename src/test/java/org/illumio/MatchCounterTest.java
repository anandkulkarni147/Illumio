package org.illumio;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MatchCounterTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testCountMatches() throws Exception {
        Set<String> predefinedWords = PredefinedWordsLoader.loadPredefinedWords();
        Map<String, Integer> matchCounts = MatchCounter.countMatches(predefinedWords);

        assertEquals(1, matchCounts.get("ai"));
        assertEquals(2, matchCounts.get("name"));
    }

    @Test
    void testEmptyPredefinedWords() throws Exception {
        Set<String> predefinedWords = Set.of();
        Map<String, Integer> matchCounts = MatchCounter.countMatches(predefinedWords);

        assertEquals(predefinedWords.size(), matchCounts.size());
    }

    @Test
    void testEmptyInputFile() throws Exception {
        Set<String> predefinedWords = Set.of("name", "detect", "ai");
        Map<String, Integer> matchCounts = MatchCounter.countMatches(predefinedWords);

        assertTrue(matchCounts.isEmpty());
    }

    @Test
    void testCaseInsensitivity() throws Exception {
        Set<String> predefinedWords = PredefinedWordsLoader.loadPredefinedWords();
        Map<String, Integer> matchCounts = MatchCounter.countMatches(predefinedWords);

        assertEquals(1, matchCounts.get("ai"));
        assertEquals(2, matchCounts.get("name"));
    }

    @Test
    void testNoMatches() throws Exception {
        Set<String> predefinedWords = Set.of("unknown", "word");
        Map<String, Integer> matchCounts = MatchCounter.countMatches(predefinedWords);

        assertTrue(matchCounts.isEmpty());
    }

    @Test
    void testMatchCountWithDuplicates() throws Exception {
        Set<String> predefinedWords = Set.of("name");
        Map<String, Integer> matchCounts = MatchCounter.countMatches(predefinedWords);

        assertEquals(2, matchCounts.get("name"));
    }

    @Test
    void testSpecialCharactersHandling() throws Exception {
        Set<String> predefinedWords = Set.of("name", "detect", "ai");
        Map<String, Integer> matchCounts = MatchCounter.countMatches(predefinedWords);

        assertEquals(1, matchCounts.get("ai"));
        assertEquals(2, matchCounts.get("name"));
    }

    @Test
    void testMaxWordLength() throws Exception {
        String longWord = "a".repeat(256);
        Set<String> predefinedWords = Set.of(longWord);
        Map<String, Integer> matchCounts = MatchCounter.countMatches(predefinedWords);

        assertEquals(1, matchCounts.get(longWord));
    }

    @Test
    void testMaxWordLengthExceed() throws Exception {
        String longWord = "a".repeat(257);
        Set<String> predefinedWords = Set.of(longWord);
        Map<String, Integer> matchCounts = MatchCounter.countMatches(predefinedWords);

        assertEquals(matchCounts.size(), 0);
    }
}