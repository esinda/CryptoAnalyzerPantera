package com.javarush.esin.constans;

public class Constans {

    private static final String RUSALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String ENGALPHABET = "ABCDEFGHIJKLMOPQRSTUVWXYZ";

    private static final String CYPHER = "0123456789";
    private static final String SYMBOLS = "\n.,:;-_+-/*=<>?!@{}[]()№#$%^&*`~'\\\"";

    public static final String ALPHABET = RUSALPHABET + RUSALPHABET.toLowerCase()
                                        + ENGALPHABET + ENGALPHABET.toLowerCase()
                                        + CYPHER + SYMBOLS;


}
