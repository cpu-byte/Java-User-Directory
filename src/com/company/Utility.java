package com.company;

import java.util.UUID;

public class Utility {

    public static String uuid() {
        return UUID.randomUUID().toString().substring(0, 7);
    }

}
