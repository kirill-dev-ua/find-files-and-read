package com.demo.files;

import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class TextFileAnalyzer {
    public long countWordOccurrences(String content, String wordToCount) {
        return Stream.of(content.split("\\s+"))
                .filter(wordToCount::equalsIgnoreCase)
                .count();
    }
}
