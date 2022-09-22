package com.redmadrobot.marketplace.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Message {
//    Продумать и реализовать вариант коммуникации между покупателем и продавцом во время совершения сделки.

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


}
