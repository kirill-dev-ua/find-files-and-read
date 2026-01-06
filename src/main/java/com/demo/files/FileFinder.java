package com.demo.files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

@Component
public class FileFinder {
    @Value("${folderPath}")
    private String folderPath;

    public Optional<Path> findLatestFile(FileExtension extension) throws IOException {
        try (Stream<Path> paths = Files.walk(Path.of(folderPath))) {
            return paths.filter(path -> path.toString().endsWith(extension.getExtension()))
                    .max(Comparator.comparing(path -> {
                        try {
                            return Files.getLastModifiedTime(path);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }));
        }
    }
}
