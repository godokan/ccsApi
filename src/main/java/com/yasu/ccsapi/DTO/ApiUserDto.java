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
    private String api_key;
    private Integer studNum;
    private String id;

    @Builder
    public ApiUserDto(@NonNull Integer no, String api_key, Integer studNum, String id) {
        this.no = no;
        this.api_key = api_key;
        this.studNum = studNum;
        this.id = id;
    }

    public ApiUserEntity toEntity() {
        return ApiUserEntity.builder()
                .no(no)
                .apiKey(api_key)
                .studNum(CcsUserEntity.builder().studNum(this.studNum).build())
                .id(CcsUserEntity.builder().id(this.id).build())
                .build();
    }
}
