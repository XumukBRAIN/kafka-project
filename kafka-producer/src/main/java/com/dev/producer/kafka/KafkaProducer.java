package com.dev.producer.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    /**
     * Отправка сообщения
     *
     * @param key Ключ
     * @param message Сообщение
     */
    public void sendMessage(String key, String message) {
        try {
            // P.S. Метод send имеет разные конструкторы, совет ознакомиться с ними
            kafkaTemplate.send("letter", key, message);
            log.info("Сообщение с ключом {} отправлено в {}", key, LocalDateTime.now());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}