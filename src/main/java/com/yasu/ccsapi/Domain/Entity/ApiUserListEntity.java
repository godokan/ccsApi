package com.yasu.ccsapi.Domain.Entity;

import com.yasu.ccsapi.DTO.ApiUserListDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "api_user_list", schema = "ccsyasu_db")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiUserListEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "no", nullable = false)
    private Integer no;

    @JoinColumn(name = "list_no", referencedColumnName = "no", insertable = false, updatable = false)
    private Integer listNo;

    @JoinColumn(name = "user_stud_num", referencedColumnName = "stud_num", insertable = false, updatable = false)
    private Integer userStudNum;

    @Column(name = "api_key", nullable = false, length = 100)
    private String apiKey;

    @Builder
    public ApiUserListEntity(Integer no, Integer listNo, Integer userStudNum, String apiKey) {
        this.no = no;
        this.listNo = listNo;
        this.userStudNum = userStudNum;
        this.apiKey = apiKey;
    }

    public ApiUserListDto toDto() {
        return ApiUserListDto.builder()
                .no(no)
                .listNo(listNo)
                .userStudNum(userStudNum)
                .apiKey(apiKey)
                .build();
    }
}