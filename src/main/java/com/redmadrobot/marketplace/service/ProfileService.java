package com.redmadrobot.marketplace.service;

import com.redmadrobot.marketplace.dto.AdvertisementDto;
import com.redmadrobot.marketplace.model.AdvertisementEntity;
import com.redmadrobot.marketplace.repository.AdvertisementEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProfileService {

    private final AdvertisementEntityRepository advertisementEntityRepository;

    public ProfileService(AdvertisementEntityRepository advertisementEntityRepository) {
        this.advertisementEntityRepository = advertisementEntityRepository;
    }

    public Optional<String> createAd(AdvertisementDto advertisementDto) {
        AdvertisementEntity entity = new AdvertisementEntity()
                .setTitle(advertisementDto.getTitle())
                .setDescription(advertisementDto.getDescription())
                .setImage(advertisementDto.getImage())
                .setStatus(advertisementDto.getStatus())
                .setSellerContact(advertisementDto.getSellerContact());
        AdvertisementEntity saved = advertisementEntityRepository.save(entity);
        String response = saved != null ? "Success" : "Failed";
        return Optional.of(response);
    }

    public List<AdvertisementEntity> findAll() {
        return advertisementEntityRepository.findAll();
    }
}
