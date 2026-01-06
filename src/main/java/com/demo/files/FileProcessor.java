package com.demo.files;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;

@Component
public record FileProcessor(
        FileFinder fileFinder,
        FileReader fileReader,
        FileAnalyzer fileAnalyzer
) {

    public long processLatestFile(String wordToCount, FileExtension fileExtension) throws IOException {

        Path latestFile = fileFinder.findLatestFile(fileExtension).orElseThrow(() -> new IllegalStateException("File with extension " + fileExtension + " not found"));

        String content = fileReader.readFileContent(latestFile);

        return fileAnalyzer.countWordOccurrences(content, wordToCount);
    }
}
