package com.javarush.esin.commands;

import com.javarush.esin.entity.Result;
import com.javarush.esin.entity.ResultCode;

public class Decoder implements Action  {

    @Override
    public Result execute(String[] parameters) {
        return new Result("decode all right", ResultCode.OK);
    }
}
