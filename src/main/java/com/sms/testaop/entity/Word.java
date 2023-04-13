package com.sms.testaop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Word {
    @Id
    Integer id;

    String word;

}
