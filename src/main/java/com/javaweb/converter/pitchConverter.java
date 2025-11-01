package com.javaweb.converter;
import com.javaweb.entity.PitchEntity;
import com.javaweb.model.dto.PitchDTO;
import com.javaweb.model.response.PitchSearchResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class pitchConverter {
    @Autowired
    private ModelMapper modelMapper;
    public PitchDTO toPitchDTO(PitchEntity pitchEntity) {
        PitchDTO pitchDTO = modelMapper.map(pitchEntity, PitchDTO.class);
        return pitchDTO;
    }
    public PitchSearchResponse toPitchSearchResponse(PitchEntity pitchEntity) {
        PitchSearchResponse pitchSearchResponse = modelMapper.map(pitchEntity, PitchSearchResponse.class);
        return pitchSearchResponse;
    }
    public PitchEntity toPitchEntity(PitchDTO pitchDTO) {
        PitchEntity pitchEntity = modelMapper.map(pitchDTO, PitchEntity.class);
        return pitchEntity;
    }

}
