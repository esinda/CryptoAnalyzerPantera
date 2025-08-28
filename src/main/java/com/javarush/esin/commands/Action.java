package com.javarush.esin.commands;

import com.javarush.esin.entity.Result;

public interface Action {

    Result execute(String[] parametrs);
}
