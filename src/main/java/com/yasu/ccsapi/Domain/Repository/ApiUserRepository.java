package com.yasu.ccsapi.Domain.Repository;

import com.yasu.ccsapi.Domain.Entity.ApiUserEntity;
import com.yasu.ccsapi.Domain.Entity.CcsUserEntity;
import org.springframework.data.repository.CrudRepository;

public interface ApiUserRepository extends CrudRepository<ApiUserEntity, Integer> {
    public ApiUserEntity findByStudNum(Integer studNum);

    public ApiUserEntity findById(String id);
}
