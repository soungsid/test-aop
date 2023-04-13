package com.sms.testaop.repository;

import com.sms.testaop.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRepository extends JpaRepository<Word, Integer> {
}
