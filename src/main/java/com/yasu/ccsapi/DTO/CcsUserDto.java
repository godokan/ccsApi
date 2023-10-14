package com.yasu.ccsapi.DTO;

import com.yasu.ccsapi.Domain.Entity.CcsUserEntity;
import lombok.Builder;
import lombok.Data;

@Data
public class CcsUserDto {
    private Integer studNum;
    private String id;
    private String pw;
    private String name;

    @Builder
    public CcsUserDto(Integer studNum, String id, String pw, String name) {
        this.studNum = studNum;
        this.id = id;
        this.pw = pw;
        this.name = name;
    }

    public CcsUserEntity toEntity() {
        return CcsUserEntity.builder()
                .studNum(studNum)
                .id(id)
                .pw(pw)
                .name(name)
                .build();
    }
}
