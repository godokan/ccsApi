package com.yasu.ccsapi.Service;

import com.yasu.ccsapi.DTO.ApiListMapDto;
import com.yasu.ccsapi.Domain.Entity.ApiListMapEntity;
import com.yasu.ccsapi.Domain.Repository.ApiListMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MapApiService {

    @Autowired
    private ApiListMapRepository mapRepository;

    public List<ApiListMapDto> getMapList() {
        List<ApiListMapEntity> entityList = (List<ApiListMapEntity>) mapRepository.findAll();
        List<ApiListMapDto> dtoList = new ArrayList<>();
        for (ApiListMapEntity entity : entityList) {
            dtoList.add(entity.toDto());
        }
        return dtoList;
    }

    // 제대로 저장 되면 true 반환
    public void newMarker(ApiListMapDto mapDto) {
        ApiListMapEntity mapEntity = mapRepository.save(mapDto.toEntity());
    }

    public boolean editMarker(ApiListMapDto mapDto) {
        ApiListMapEntity mapEntity = mapRepository.findById(mapDto.getNo()).orElse(null);

        if (mapEntity!=null) {
            mapRepository.save(mapDto.toEntity());
            return true;
        }
        return false;
    }

    public boolean deleteMarker(Integer no) {
        ApiListMapEntity mapEntity = mapRepository.findById(no).orElse(null);
        if (mapEntity!=null) {
            mapRepository.delete(mapEntity);
            return true;
        }
        return false;
    }
}
