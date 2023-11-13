package com.yasu.ccsapi.Service;

import com.yasu.ccsapi.Domain.Entity.ApiUserListEntity;
import com.yasu.ccsapi.Domain.Repository.ApiUserListRepository;
import com.yasu.ccsapi.Domain.Repository.ApiUserRepository;
import com.yasu.ccsapi.security.CryptoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    ApiUserRepository apiUserRepository;
    @Autowired
    ApiUserListRepository userListRepository;

    private CryptoManager cryptoManager;

//    public String decrypt(String key, Integer studNum) throws Exception {
//        String out = cryptoManager.decrypt(key, String.valueOf(studNum));
//
//    }

    public void auth(String key, Integer studNum) {
        // API KEY 구조 : {회원 ID}/{API 이름}
        // API KEY 에 대한 복호화 키 : {학번}
        String[] strings = key.split("/");
        userListRepository.findByUserStudNumAndListName(studNum,strings[1]);
        // TODO : 유저 리스트 조회 해 유효한 키 인지, 어디에 연결 되는 지 조회
    }

}
