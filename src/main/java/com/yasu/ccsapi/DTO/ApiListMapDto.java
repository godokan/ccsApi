package com.yasu.ccsapi.DTO;

import com.yasu.ccsapi.Domain.Entity.ApiListMapEntity;
import lombok.Builder;
import lombok.Data;

@Data
public class ApiListMapDto {
    private Integer no;
    private String name;
    private String properName;
    private Double lat;
    private Double lng;
    private String address;
    private String placeUrl;

    @Builder
    public ApiListMapDto(Integer no, String name, String properName, Double lat, Double lng, String address, String placeUrl) {
        this.no = no;
        this.name = name;
        this.properName = properName;
        this.lat = lat;
        this.lng = lng;
        this.address = address;
        this.placeUrl = placeUrl;
    }

    public ApiListMapEntity toEntity() {
        return ApiListMapEntity.builder()
                .no(no)
                .name(name)
                .properName(properName)
                .lat(lat)
                .lng(lng)
                .address(address)
                .placeUrl(placeUrl)
                .build();
    }
}
