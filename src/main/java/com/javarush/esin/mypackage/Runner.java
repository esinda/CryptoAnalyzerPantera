package com.javarush.esin.mypackage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        // Часть 1. Берем текстовый файл и превращаем всё в символы.
        List<String> list;
        try {
            Path path = Path.of("C:\\Users\\Admin\\IdeaProjects\\CryptoAnalyzerPantera\\text\\mytext1.txt");
            list = Files.readAllLines(path);

            for (String line : list) {
                char[] chars = line.toCharArray();
                for (char c : chars) {
                    System.out.print(c); // вывод символа
                }
                System.out.println(); // перенос строки, чтобы текст выглядел как в файле
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Здесь вроде у нас всё выводится, sout можно будет потом убрать.

        // Часть 2. Теперь надо попробовать выполнить какие-нибдь манипуляции с символами;
        // Хотя, наверное пора бы сделать алфавит




    }
}


