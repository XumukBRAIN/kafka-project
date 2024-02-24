package com.dev.producer.utils;

import java.util.UUID;

public class Utils {

    public static String generateKafkaMessageKey() {
        return String.valueOf(UUID.randomUUID());
    }
}
