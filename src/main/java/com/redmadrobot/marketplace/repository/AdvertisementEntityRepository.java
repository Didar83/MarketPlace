package com.redmadrobot.marketplace.repository;

import com.redmadrobot.marketplace.model.AdvertisementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementEntityRepository extends JpaRepository<AdvertisementEntity, Long> {
}
