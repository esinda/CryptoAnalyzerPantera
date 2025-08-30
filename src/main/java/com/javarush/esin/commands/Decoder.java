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

public class Decoder implements Action {

    private static final String INPUT_FILE = "encoder.txt";
    private static final String OUTPUT_FILE = "decoder.txt";

    @Override
    public Result execute(String[] parameters) {
        if (parameters.length < 1) {
            return new Result("Not enough parameters. Usage: decode <key>", ResultCode.ERROR);
        }

        // Парсим ключ
        KeyParser.ResultWithKey keyResult = KeyParser.parseKey(parameters[0]);
        if (keyResult.error() != null) return keyResult.error();

        // Готовим пути (вход всегда encoder.txt)
        PathHelper.ResultWithPaths paths = PathHelper.preparePaths(INPUT_FILE, OUTPUT_FILE);
        if (paths.error() != null) return paths.error();

        // Читаем - дешифруем и пишем
        try {
            List<String> inputLines = Files.readAllLines(paths.inputPath());
            List<String> outputLines = new ArrayList<>();
            for (String line : inputLines) {
                outputLines.add(CaesarCipher.shiftText(line, keyResult.key(), false));
            }
            Files.write(paths.outputPath(), outputLines);
        } catch (IOException e) {
            return new Result("Error processing file: " + e.getMessage(), ResultCode.ERROR);
        }

        return new Result("File decrypted: " + OUTPUT_FILE, ResultCode.OK);
    }
}