package com.yasu.ccsapi.Service;

import com.yasu.ccsapi.Domain.Entity.ApiListEntity;
import com.yasu.ccsapi.Domain.Entity.ApiUserListEntity;
import com.yasu.ccsapi.Domain.Repository.ApiListRepository;
import com.yasu.ccsapi.Domain.Repository.ApiUserListRepository;
import com.yasu.ccsapi.Domain.Repository.ApiUserRepository;
import com.yasu.ccsapi.security.CryptoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    ApiUserRepository userRepository;
    @Autowired
    ApiUserListRepository userListRepository;
    @Autowired
    ApiListRepository apiListRepository;

    public String issue(String id, Integer stdNum, String apiName) throws Exception {
        // API KEY 구조 : {회원 ID}/{API 이름}
        // API KEY 에 대한 복호화 키 : {학번}

        ApiListEntity apiList = apiListRepository.findByName(apiName);

        String issuedKey;
        CryptoManager manager = new CryptoManager();

        issuedKey = manager.encrypt(id+"/"+apiName, String.valueOf(stdNum));

        ApiUserListEntity entity = ApiUserListEntity.builder()
                .apiKey(issuedKey)
                .userStudNum(stdNum)
                .listNo(apiList.getNo())
            .build();

        userListRepository.save(entity);

        return issuedKey;
    }
}
