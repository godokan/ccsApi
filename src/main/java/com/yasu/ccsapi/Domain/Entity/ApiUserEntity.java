package com.yasu.ccsapi.Domain.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "api_user", schema = "ccsyasu_db")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiUserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "no", nullable = false)
    private Integer no;

    @JoinColumn(name = "stud_num", referencedColumnName = "stud_num", insertable = false, updatable = false)
    private Integer studNum;

    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private String id;

    @Builder
    public ApiUserEntity(Integer no, Integer studNum, String id) {
        this.no = no;
        this.studNum = studNum;
        this.id = id;
    }
}
