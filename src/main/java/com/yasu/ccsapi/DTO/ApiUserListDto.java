package com.yasu.ccsapi.DTO;

import com.yasu.ccsapi.Domain.Entity.ApiUserListEntity;
import lombok.Builder;
import lombok.Data;

@Data
public class ApiUserListDto {

    private Integer no;
    private Integer listNo;
    private Integer userStudNum;
    private String apiKey;

    @Builder
    public ApiUserListDto(Integer no, Integer listNo, Integer userStudNum, String apiKey) {
        this.no = no;
        this.listNo = listNo;
        this.userStudNum = userStudNum;
        this.apiKey = apiKey;
    }

    public ApiUserListEntity toEntity() {
        return ApiUserListEntity.builder()
                .no(no)
                .listNo(listNo)
                .userStudNum(userStudNum)
                .apiKey(apiKey)
                .build();
    }
}
