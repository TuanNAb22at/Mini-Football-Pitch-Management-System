package com.javaweb.repository;

import com.javaweb.entity.PitchRentalDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PitchRentalDetailRepository extends JpaRepository<PitchRentalDetailEntity,Long> {

}
