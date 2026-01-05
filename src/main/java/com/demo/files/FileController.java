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
    public long analyzeFile(@RequestParam String word) throws IOException {
        return fileProcessor.processLatestTextFile(word);
    }
}
