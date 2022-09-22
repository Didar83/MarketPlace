package com.redmadrobot.marketplace.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Accessors(chain = true)
public class AdvertisementEntity {
    //    Объявление содержит:
    //    название,
    //    описание,
    //    контакты продавца
    //    и изображения.
    //    Объявления имеют 2 статуса - активное и снятое с публикации.
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private String description;
    private String sellerContact;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
    @Column(name = "image", nullable = false, length = 100000)
    private byte[] image;
}
