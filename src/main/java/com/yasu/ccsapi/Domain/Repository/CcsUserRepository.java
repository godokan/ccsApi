package com.yasu.ccsapi.Domain.Repository;

import com.yasu.ccsapi.Domain.Entity.CcsUserEntity;
import org.springframework.data.repository.CrudRepository;

public interface CcsUserRepository extends CrudRepository<CcsUserEntity, Integer> {
    public CcsUserEntity findCcsUserEntityByIdAndPw(String id, String pw);

    public CcsUserEntity findCcsUserEntityById(String id);

    public CcsUserEntity findByStudNum(Integer studNum);
}
