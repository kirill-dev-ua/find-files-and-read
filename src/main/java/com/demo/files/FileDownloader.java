package com.demo.files;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class FileDownloader {
    public String downloadFileContent(Path latestTxtKey) {
        try {
            return  new String(Files.readAllBytes(latestTxtKey));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
