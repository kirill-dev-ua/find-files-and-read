package com.demo.files;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Optional;

@Component
public class FileFinder {
    private final Path folderPath = Path.of("src/main/resources/direct");

    public Optional<Path> findLatestTxtFile() throws IOException {
        return Files.walk(folderPath)
                .filter(path -> path.toString().endsWith(".txt"))
                .max(Comparator.comparing(path -> {
                    try {
                        return Files.getLastModifiedTime(path);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }));
    }
}
