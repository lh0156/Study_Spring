package com.oraclejava.day2;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class KeyGenerator {
    protected static final long WEAK_KEY = 0xFFFFFFF0000000L;
    protected static final long STRONG_KEY = 0xABCDF03F590AE56L;

    private Random rnd = new Random();

    public long getKey() {
        int x = rnd.nextInt(3);
        if (x == 1) {
            return WEAK_KEY;
        }

        return STRONG_KEY;
    }



}
