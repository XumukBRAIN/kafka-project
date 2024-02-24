package com.dev.consumer.kafka;

import com.dev.consumer.models.Letter;
import com.dev.consumer.services.LetterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final LetterService service;
    private final ObjectMapper objectMapper;

    /**
     * Прием сообщения на сохранения письма
     *
     * @param key Ключ
     * @param msg Сообщение
     */
    @KafkaListener(topics = "letter", groupId = "letter_consumer")
    public void listen(@Header(KafkaHeaders.RECEIVED_KEY) String key, String msg) {
        log.info("Поступило сообщение на сохранение письма");
        try {
            // Конвертация JSON в Java-объект
            Letter letter = objectMapper.readValue(msg, Letter.class);
            UUID savedId = service.save(letter);
            log.info("Письмо из сообщения с ключом {} успешно сохранено. Присвоен идентификатор: {}", key, savedId);
        } catch (JsonProcessingException e) {
            log.error("Ошибка во время конвертации сообщения с ключом {} в объект", key);
            throw new RuntimeException(e);
        } catch (Exception e) {
            log.error("Ошибка сохранения письма с ключом {}", key);
        }
    }
}