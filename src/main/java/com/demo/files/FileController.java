package com.demo.files;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {
    private final FileProcessor fileProcessor;

    @GetMapping("/analyze")
    public long analyzeFile(@RequestParam String word, @RequestParam String extension) throws IOException {
        return fileProcessor.processLatestFile(word, FileExtension.valueOf(extension));
    }
}
