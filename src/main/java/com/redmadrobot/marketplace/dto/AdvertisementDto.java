package com.redmadrobot.marketplace.dto;

import com.redmadrobot.marketplace.model.Status;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class AdvertisementDto {
    private String title;
    private String description;
    private String sellerContact;
    private Status status;
    private byte[] image;
}
