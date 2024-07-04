package org.illumio;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PredefinedWordsLoaderTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testLoadPredefinedWords() throws Exception {
        Set<String> predefinedWords = PredefinedWordsLoader.loadPredefinedWords();
        assertEquals(Set.of("name", "detect", "ai"), predefinedWords);
    }

}