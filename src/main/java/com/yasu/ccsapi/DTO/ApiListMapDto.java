package com.yasu.ccsapi.DTO;

import com.yasu.ccsapi.Domain.Entity.ApiListMapEntity;
import lombok.Builder;
import lombok.Data;

@Data
public class ApiListMapDto {
    private Integer no;
    private String name;
    private Double lat;
    private Double lng;
    private String address;

    @Builder
    public ApiListMapDto(Integer no,String name, Double lat, Double lng, String address) {
        this.no = no;
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.address = address;
    }

    public ApiListMapEntity toEntity() {
        return ApiListMapEntity.builder()
                .no(no)
                .name(name)
                .lat(lat)
                .lng(lng)
                .address(address)
                .build();
    }
}
