package com.javarush.esin.utils;

import com.javarush.esin.constans.Constans;
import com.javarush.esin.entity.Result;
import com.javarush.esin.entity.ResultCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PathHelper {

    public record ResultWithPaths(Path inputPath, Path outputPath, Result error) {
    }

    public static ResultWithPaths preparePaths(String inputFileName, String outputFileName) {
        try {
            Path folder = Path.of(Constans.TXT_FOLDER);
            if (!Files.exists(folder)) {
                Files.createDirectories(folder);
            }

            Path inputPath = Path.of(Constans.TXT_FOLDER, inputFileName);
            if (!Files.exists(inputPath)) {
                return new ResultWithPaths(null, null,
                        new Result("File not found: " + inputPath.toAbsolutePath(), ResultCode.ERROR));
            }

            Path outputPath = Path.of(Constans.TXT_FOLDER, outputFileName);
            return new ResultWithPaths(inputPath, outputPath, null);

        } catch (IOException e) {
            return new ResultWithPaths(null, null,
                    new Result("Error preparing paths: " + e.getMessage(), ResultCode.ERROR));
        }
    }
}