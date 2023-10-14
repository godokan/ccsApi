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
}
