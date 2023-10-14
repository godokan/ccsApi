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

    @Column(name = "api_key", nullable = false, length = 100)
    private String apiKey;

    @ManyToOne(cascade = CascadeType.REMOVE, targetEntity = CcsUserEntity.class)
    @JoinColumn(name = "stud_num", referencedColumnName = "stud_num", insertable = false, updatable = false)
    private CcsUserEntity studNum;

    @Builder
    public ApiUserEntity(Integer no, String apiKey, CcsUserEntity studNum) {
        this.no = no;
        this.apiKey = apiKey;
        this.studNum = studNum;
    }
}
