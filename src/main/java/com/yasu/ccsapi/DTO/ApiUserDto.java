package com.yasu.ccsapi.DTO;

import com.yasu.ccsapi.Domain.Entity.ApiUserEntity;
import com.yasu.ccsapi.Domain.Entity.CcsUserEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
public class ApiUserDto {
    @NonNull
    private Integer no;
    private Integer studNum;
    private String id;

    @Builder
    public ApiUserDto(@NonNull Integer no, Integer studNum, String id) {
        this.no = no;
        this.studNum = studNum;
        this.id = id;
    }

    public ApiUserEntity toEntity() {
        return ApiUserEntity.builder()
                .no(no)
                .studNum(CcsUserEntity.builder().studNum(this.studNum).build())
                .id(id)
                .build();
    }
}
