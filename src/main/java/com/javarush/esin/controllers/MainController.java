package com.javarush.esin.controllers;
import com.javarush.esin.commands.Action;
import com.javarush.esin.entity.Result;

public class MainController {

    public Result doAction(String actionName, String[] parameters) {

        Action action = Actions.find(actionName);

        return action.execute(parameters);
    }
}
