package com.yasu.ccsapi.Domain.Entity;

import com.yasu.ccsapi.DTO.ApiListMapDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "api_list_map", schema = "ccsyasu_db")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiListMapEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "no", nullable = false)
    private Integer no;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "proper_name", nullable = false, length = 100)
    private String properName;

    @Column(name = "lat", nullable = false, scale = 6)
    private Double lat;

    @Column(name = "lng", nullable = false, scale = 6)
    private Double lng;

    @Column(name = "address", nullable = false, length = 150)
    private String address;

    @Column(name = "place_url", nullable = false, length = 100)
    private String placeUrl;

    @Builder
    public ApiListMapEntity(Integer no, String name, String properName, Double lat, Double lng, String address, String placeUrl) {
        this.no = no;
        this.name = name;
        this.properName = properName;
        this.lat = lat;
        this.lng = lng;
        this.address = address;
        this.placeUrl = placeUrl;
    }

    public ApiListMapDto toDto() {
        return ApiListMapDto.builder()
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
