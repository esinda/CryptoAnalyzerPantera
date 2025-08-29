package com.javarush.esin.utils;

import com.javarush.esin.constans.Constans;

public class CaesarCipher {

    public static String shiftText(String text, int key, boolean encode) {
        StringBuilder result = new StringBuilder();
        String alphabet = Constans.ALPHABET;
        int n = alphabet.length();

        for (char c : text.toCharArray()) {
            int index = alphabet.indexOf(c);
            if (index == -1) {
                result.append(c);
            } else {
                int shift = encode ? key : -key;
                int newIndex = (index + shift + n) % n;
                result.append(alphabet.charAt(newIndex));
            }
        }
        return result.toString();
    }
}