package com.yasu.ccsapi.Domain.Repository;

import com.yasu.ccsapi.Domain.Entity.ApiUserEntity;
import org.springframework.data.repository.CrudRepository;

public interface ApiUserRepository extends CrudRepository<ApiUserEntity, Integer> {

}
