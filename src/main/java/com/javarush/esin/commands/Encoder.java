package com.javarush.esin.commands;

import com.javarush.esin.entity.Result;
import com.javarush.esin.entity.ResultCode;
import com.javarush.esin.utils.CaesarCipher;
import com.javarush.esin.utils.KeyParser;
import com.javarush.esin.utils.PathHelper;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Encoder implements Action {

    private static final String OUTPUT_FILE = "encoder.txt";

    @Override
    public Result execute(String[] parameters) {
        if (parameters.length < 2) {
            return new Result("Not enough parameters. Usage: encode <filename> <key>", ResultCode.ERROR);
        }

        // 1) Парсим ключ
        KeyParser.ResultWithKey keyResult = KeyParser.parseKey(parameters[1]);
        if (keyResult.error != null) return keyResult.error;

        // 2) Готовим пути
        PathHelper.ResultWithPaths paths = PathHelper.preparePaths(parameters[0], OUTPUT_FILE);
        if (paths.error() != null) return paths.error();

        // 3) Читаем → шифруем → пишем
        try {
            List<String> inputLines = Files.readAllLines(paths.inputPath());
            List<String> outputLines = new ArrayList<>();
            for (String line : inputLines) {
                outputLines.add(CaesarCipher.shiftText(line, keyResult.key, true));
            }
            Files.write(paths.outputPath(), outputLines);
        } catch (IOException e) {
            return new Result("Error processing file: " + e.getMessage(), ResultCode.ERROR);
        }

        return new Result("File encrypted: " + OUTPUT_FILE, ResultCode.OK);
    }
}