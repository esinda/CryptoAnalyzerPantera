package com.javarush.esin.constans;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;

public class Constans {

    private static final String RUSALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String ENGALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // добавлена N
    private static final String CYPHER = "0123456789";

    private static final String SYMBOLS = "\n.,:;-_+/*=<>?!@{}[]()№#$%^&*`~'\\\" ";

    public static final String ALPHABET = buildAlphabet();

    public static final String TXT_FOLDER = System.getProperty("user.dir")
            + File.separator + "text" + File.separator;

    private static String buildAlphabet() {
        StringBuilder sb = new StringBuilder();
        String combined = RUSALPHABET
                + RUSALPHABET.toLowerCase()
                + ENGALPHABET
                + ENGALPHABET.toLowerCase()
                + CYPHER
                + SYMBOLS;

        Set<Character> seen = new LinkedHashSet<>();
        for (char c : combined.toCharArray()) {
            if (seen.add(c)) {       // add возвращает false, если уже был
                sb.append(c);
            }
        }
        return sb.toString();
    }
}