package com.javaweb.service.impl;

import com.javaweb.converter.pitchConverter;
import com.javaweb.entity.PitchEntity;
import com.javaweb.model.dto.PitchDTO;
import com.javaweb.model.response.PitchSearchResponse;
import com.javaweb.repository.PitchRepository;
import com.javaweb.service.IPitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PitchService  implements IPitchService {
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
    public List<PitchSearchResponse> findAvailablePitchesToday() {
        List<PitchSearchResponse> pitchSearchResponse = new ArrayList<>();
        List<PitchEntity> pitchEntitys  = pitchRepository.findAvailablePitchesToday();
        for(PitchEntity pitchEntity : pitchEntitys){
            pitchSearchResponse.add(pitchConverters.toPitchSearchResponse(pitchEntity));
        }
        return pitchSearchResponse;
    }

    @Override
    public void deletePitch(Long id) {
        if (!pitchRepository.existsById(id)) {
            throw new RuntimeException("Sân bóng không tồn tại");
        }
        pitchRepository.deleteById(id);
    }

    public List<String> getAllPitchTypes() {
        return pitchRepository.findAllPitchTypes();
    }


    @Override
    public PitchDTO savePitch(PitchDTO pitchDTO) {
        pitchRepository.save(pitchConverters.toPitchEntity(pitchDTO));
        return pitchDTO;
    }

    @Override
    public PitchDTO updatePitch(PitchDTO pitchDTO) {
        pitchRepository.save(pitchConverters.toPitchEntity(pitchDTO));
        return pitchDTO;
    }

    @Override
    public PitchDTO findById(Long id) {
        PitchDTO pitchDTO = pitchConverters.toPitchDTO(pitchRepository.findById(id).get());
        return pitchDTO;
    }
}
