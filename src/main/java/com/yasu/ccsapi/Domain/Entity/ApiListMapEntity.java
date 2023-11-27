package com.yasu.ccsapi.Domain.Entity;

import com.yasu.ccsapi.DTO.ApiListMapDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "api_list_toiletmap", schema = "ccsyasu_db")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiListMapEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "no", nullable = false)
    private Integer no;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "lat", nullable = false, scale = 12)
    private Double lat;

    @Column(name = "lng", nullable = false, scale = 12)
    private Double lng;

    @Column(name = "address", nullable = false, length = 150)
    private String address;

    @Builder
    public ApiListMapEntity(Integer no, String name, Double lat, Double lng, String address) {
        this.no = no;
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.address = address;
    }

    public ApiListMapDto toDto() {
        return ApiListMapDto.builder()
                .no(no)
                .name(name)
                .lat(lat)
                .lng(lng)
                .address(address)
                .build();
    }
}
