package com.example.demo.utility;

import java.util.concurrent.ThreadLocalRandom;

public class IdGenerator
{
    public int generateId()
    {
        return ThreadLocalRandom.current().nextInt(1000, 9999 + 1);
    }
}
