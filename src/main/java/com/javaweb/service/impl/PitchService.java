package com.javaweb.service.impl;

import com.javaweb.converter.pitchConverter;
import com.javaweb.entity.PitchEntity;
import com.javaweb.model.response.PitchSearchResponse;
import com.javaweb.repository.PitchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PitchService {
    @Autowired
    private  PitchRepository pitchRepository;
    @Autowired
    private pitchConverter pitchConverters;

    public List<PitchSearchResponse> getAvailablePitches(String startDate, String endDate, String pitchTypeId) {
        List<PitchSearchResponse>  pitchSearchResponse = new ArrayList<>();
        List<PitchEntity> pitchEntitys =pitchRepository.findAvailablePitches(startDate, endDate, pitchTypeId);
        for(PitchEntity pitchEntity : pitchEntitys){
            pitchSearchResponse.add(pitchConverters.toPitchSearchResponse(pitchEntity));
        }
        return pitchSearchResponse;
    }
}
