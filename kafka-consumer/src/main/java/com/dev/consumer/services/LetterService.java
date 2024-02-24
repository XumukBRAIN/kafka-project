package com.dev.consumer.services;

import com.dev.consumer.models.Letter;
import com.dev.consumer.repository.LetterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class LetterService {

    private final LetterRepository repository;

    /**
     * Сохранение письма
     *
     * @param letter Данные письма
     * @return Идентификатор
     */
    public UUID save(Letter letter) {
        UUID id;
        try {
            Letter saved = repository.save(letter);
            id = saved.getId();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return id;
    }
}