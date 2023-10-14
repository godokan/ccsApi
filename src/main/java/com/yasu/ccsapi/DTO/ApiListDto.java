package com.yasu.ccsapi.DTO;

import com.yasu.ccsapi.Domain.Entity.ApiListEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
public class ApiListDto {
    @NonNull
    private Integer no;
    private String name;
    private String description;
    private String id;

    @Builder
    public ApiListDto(@NonNull Integer no, String name, String description, String id) {
        this.no = no;
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public ApiListEntity toEntity() {
        return ApiListEntity.builder()
                .no(no)
                .name(name)
                .description(description)
                .id(id)
                .build();
    }
}
