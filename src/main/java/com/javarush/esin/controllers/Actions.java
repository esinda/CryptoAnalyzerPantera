package com.javarush.esin.controllers;

import com.javarush.esin.commands.Action;
import com.javarush.esin.commands.Decoder;
import com.javarush.esin.commands.Encoder;
import com.javarush.esin.exceptions.AppException;

public enum Actions {
    ENCODE(new Encoder()),
    DECODE(new Decoder());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String actionName) {
        try {
            Actions value = Actions.valueOf(actionName.toUpperCase());
            return value.action;
        } catch (IllegalArgumentException e) {
            throw new AppException("not found " + actionName, e);
        }
    }
}
