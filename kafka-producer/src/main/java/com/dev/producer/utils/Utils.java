package com.dev.producer.utils;

import java.util.UUID;

/**
 * Утилитарный класс
 */
public class Utils {

    /**
     * Генерация ключа для сообщения
     *
     * @return Ключ
     */
    public static String generateKafkaMessageKey() {
        return String.valueOf(UUID.randomUUID());
    }
}