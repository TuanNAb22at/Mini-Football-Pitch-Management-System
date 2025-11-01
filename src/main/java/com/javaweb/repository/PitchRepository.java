package com.javaweb.repository;

import com.javaweb.entity.PitchEntity;
import com.javaweb.repository.custom.PitchRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface PitchRepository extends JpaRepository<PitchEntity, Long> , PitchRepositoryCustom {
    List<PitchEntity> findByTypeContaining(String type);
}



