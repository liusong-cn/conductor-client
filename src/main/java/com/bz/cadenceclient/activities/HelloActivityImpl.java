package com.bz.cadenceclient.activities;

import java.io.PrintStream;

/**
 * @author:11411
 * @date: 2020/8/7 11:23
 **/
public class HelloActivityImpl implements HelloActivity {

    private final PrintStream out;

    public HelloActivityImpl(PrintStream out){
        this.out = out;
    }

    @Override
    public void say(String mes) {
        out.println(mes);
    }
}
