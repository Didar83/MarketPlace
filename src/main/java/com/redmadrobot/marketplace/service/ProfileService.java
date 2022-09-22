package com.redmadrobot.marketplace.service;

import com.redmadrobot.marketplace.dto.AdvertisementDto;
import com.redmadrobot.marketplace.model.AdvertisementEntity;
import com.redmadrobot.marketplace.repository.AdvertisementEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProfileService {

    private final AdvertisementEntityRepository advertisementEntityRepository;

    public ProfileService(AdvertisementEntityRepository advertisementEntityRepository) {
        this.advertisementEntityRepository = advertisementEntityRepository;
    }

    public String createAds(AdvertisementDto advertisementDto) {
        AdvertisementEntity entity = new AdvertisementEntity()
                .setTitle(advertisementDto.getTitle())
                .setDescription(advertisementDto.getDescription())
                .setImage(advertisementDto.getImage())
                .setStatus(advertisementDto.getStatus())
                .setSellerContact(advertisementDto.getSellerContact());
        AdvertisementEntity saved = advertisementEntityRepository.save(entity);
        return saved != null ? "Success" : "Failed";
    }
}
