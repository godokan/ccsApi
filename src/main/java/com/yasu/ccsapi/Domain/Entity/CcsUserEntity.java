package com.yasu.ccsapi.Domain.Entity;

import com.yasu.ccsapi.DTO.CcsUserDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ccs_user", schema = "ccsyasu_db")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CcsUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no", unique = true, nullable = false)
    private Integer no;

    @Column(name = "stud_num", unique = true, nullable = false)
    private Integer studNum;

    @Column(name = "id", nullable = false, length = 20)
    private String id;

    @Column(name = "pw", nullable = false, length = 100)
    private String pw;

    @Column(name = "name", nullable = false, length = 40)
    private String name;

    @Builder
    public CcsUserEntity(Integer studNum, String id, String pw, String name) {
        this.studNum = studNum;
        this.id = id;
        this.pw = pw;
        this.name = name;
    }

    public CcsUserDto toDto() {
        return CcsUserDto.builder()
                .studNum(studNum)
                .id(id)
                .pw(pw)
                .name(name)
                .build();
    }
}
