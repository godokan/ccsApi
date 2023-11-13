package com.yasu.ccsapi.Domain.Repository;

import com.yasu.ccsapi.Domain.Entity.ApiUserListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApiUserListRepository extends JpaRepository<ApiUserListEntity, Integer> {
    public List<ApiUserListEntity> findApiUserListEntitiesByUserStudNum(Integer StudNum);
}
