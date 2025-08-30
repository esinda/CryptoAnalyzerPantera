package com.javarush.esin.utils;

import com.javarush.esin.constans.Constans;
import com.javarush.esin.entity.Result;
import com.javarush.esin.entity.ResultCode;

public class KeyParser {

    public record ResultWithKey(Integer key, Result error) {
    }

    public static ResultWithKey parseKey(String keyStr) {
        int key;
        try {
            key = Integer.parseInt(keyStr);
        } catch (NumberFormatException e) {
            return new ResultWithKey(null, new Result("Key must be an integer", ResultCode.ERROR));
        }

        int max = Constans.ALPHABET.length(); // допустимый диапазон: [0..max-1]
        if (key < 0 || key >= max) {
            return new ResultWithKey(null,
                    new Result("Key must be between 0 and " + (max - 1), ResultCode.ERROR));
        }

        return new ResultWithKey(key, null);
    }
}