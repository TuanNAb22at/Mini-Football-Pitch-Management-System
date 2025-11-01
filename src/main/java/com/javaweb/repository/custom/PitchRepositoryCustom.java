package com.javaweb.repository.custom;

import com.javaweb.entity.PitchEntity;

import java.time.LocalDate;
import java.util.List;

public interface PitchRepositoryCustom {
    List<PitchEntity> findAvailablePitches(String startDate, String endDate, String pitchTypeId);
}
