package com.demo.files;

import lombok.Getter;

@Getter
public enum FileExtension {
    TXT(".txt");

    private final String extension;

    FileExtension(String extension) {
        this.extension = extension;
    }
}
