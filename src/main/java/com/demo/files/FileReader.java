package com.demo.files;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class FileReader {
    public String readFileContent(Path latestKey) {
        try {
            //TODO переписать readAllBytes и вычитывать файл построчно
            return new String(Files.readAllBytes(latestKey));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
