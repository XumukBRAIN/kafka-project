package com.dev.producer.controllers;

import com.dev.producer.kafka.KafkaProducer;
import com.dev.producer.models.Letter;
import com.dev.producer.utils.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/letter")
@RequiredArgsConstructor
public class LetterController {

    private final KafkaProducer producer;
    private final ObjectMapper mapper;

    @PostMapping("/send")
    public ResponseEntity<String> send(@RequestBody Letter letter) {
        String key = Utils.generateKafkaMessageKey();
        try {
            producer.sendMessage(mapper.writeValueAsString(letter));
            log.info("Отправлено сообщение по кафке с ключом {} в {}", key, LocalDateTime.now());
        } catch (Exception e) {
            log.error("Ошибка при отправке сообщения: {}. Ключ = {}", e.getMessage(), key);
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok("Сообщение успешно отослано \nКлюч: " + key);
    }
}
