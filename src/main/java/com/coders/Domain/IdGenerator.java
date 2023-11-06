package com.coders.Domain;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
    private AtomicInteger idGenerator = new AtomicInteger(0);

    public int GenerateId(){
        return idGenerator.incrementAndGet();
    }
}

