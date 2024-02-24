package com.dev.consumer.repository;

import com.dev.consumer.models.Letter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LetterRepository extends JpaRepository<Letter, UUID> {
}