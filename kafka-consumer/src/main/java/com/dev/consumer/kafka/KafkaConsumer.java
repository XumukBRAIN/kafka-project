package com.dev.consumer.kafka;

import com.dev.consumer.models.Letter;
import com.dev.consumer.services.LetterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final LetterService service;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "letter", groupId = "my_consumer")
    public void save(String msg) {
        log.info("Поступило сообщение на сохранение письма");
        try {
            Letter letter = objectMapper.readValue(msg, Letter.class);
            service.save(letter);
        } catch (JsonProcessingException e) {
            log.error("Ошибка во время конвертации сообщения в объект");
            throw new RuntimeException(e);
        }
    }
}
