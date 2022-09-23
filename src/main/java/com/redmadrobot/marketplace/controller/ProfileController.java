package com.redmadrobot.marketplace.controller;


import com.redmadrobot.marketplace.dto.AdvertisementDto;
import com.redmadrobot.marketplace.model.AdvertisementEntity;
import com.redmadrobot.marketplace.service.ProfileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/profile")
public class ProfileController {

//    В личном кабинете пользователь может создать объявление и разместить его на доске объявлений в общем списке.
//    Объявление содержит название, описание, контакты продавца и изображения.

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @ApiOperation(value = "Create new Advertisement")
    @PostMapping("/createAd")
    public ResponseEntity createAd(@RequestBody AdvertisementDto advertisementDto) {
        return ResponseEntity.of(profileService.createAd(advertisementDto));
    }

    @ApiOperation(value = "Find all Advertisements")
    @GetMapping("/findAll")
    public ResponseEntity<List<AdvertisementEntity>> findAll() {
        List<AdvertisementEntity> allAds = profileService.findAll();
        return ResponseEntity.of(Optional.of(allAds));
    }
}
