package com.demo.files;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

@Component
public record FileProcessor(FileFinder fileFinder, FileDownloader fileDownloader, TextFileAnalyzer textFileAnalyzer) {
    public long processLatestTextFile(String wordToCount) throws IOException {
        Optional<Path> latestTxtKey = fileFinder.findLatestTxtFile();
        String counter = fileDownloader.downloadFileContent(latestTxtKey.orElse(null));
        System.out.println(textFileAnalyzer.countWordOccurrences(counter, wordToCount));
        return textFileAnalyzer.countWordOccurrences(counter, wordToCount);
    }
}
