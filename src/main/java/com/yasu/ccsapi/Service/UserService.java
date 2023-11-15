package com.yasu.ccsapi.Service;

import com.yasu.ccsapi.DTO.ApiUserDto;
import com.yasu.ccsapi.Domain.Entity.ApiListEntity;
import com.yasu.ccsapi.Domain.Entity.ApiUserEntity;
import com.yasu.ccsapi.Domain.Entity.ApiUserListEntity;
import com.yasu.ccsapi.Domain.Entity.CcsUserEntity;
import com.yasu.ccsapi.Domain.Repository.ApiListRepository;
import com.yasu.ccsapi.Domain.Repository.ApiUserListRepository;
import com.yasu.ccsapi.Domain.Repository.ApiUserRepository;
import com.yasu.ccsapi.Domain.Repository.CcsUserRepository;
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
    @Autowired
    CcsUserRepository ccsUserRepository;

    // API 발급
    public String issue(String id, Integer studNum, String apiId) throws Exception {
        // API KEY 구조 : {회원 ID}/{API ID}
        // API KEY 에 대한 복호화 키 : {학번}

        ApiListEntity apiList = apiListRepository.findById(apiId);

        String issuedKey;
        CryptoManager manager = new CryptoManager();

        issuedKey = manager.encrypt(id+"/"+apiId, String.valueOf(studNum));

        ApiUserListEntity entity = ApiUserListEntity.builder()
                .apiKey(issuedKey)
                .userStudNum(studNum)
                .listName(apiList.getName())
            .build();

        userListRepository.save(entity);

        return issuedKey;
    }

    // API 사용자 등록 여부 확인
    public boolean isSigned(Integer studNum) {
        ApiUserEntity userEntity = userRepository.findByStudNum(studNum);
        return userEntity != null;
    }

    // API 사용자 등록
    public boolean signup(Integer studNum, String id) {
        CcsUserEntity ccsUser = ccsUserRepository.findByStudNum(studNum);
        if (ccsUser == null) return false;

        ApiUserEntity userEntity = ApiUserEntity.builder()
                .studNum(ccsUser.getStudNum())
                .id(id)
                .build();

        userRepository.save(userEntity);

        return true;
    }
}
