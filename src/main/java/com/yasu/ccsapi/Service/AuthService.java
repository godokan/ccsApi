package com.yasu.ccsapi.Service;

import com.yasu.ccsapi.DTO.ErrorDto;
import com.yasu.ccsapi.Domain.Entity.ApiListEntity;
import com.yasu.ccsapi.Domain.Entity.ApiUserEntity;
import com.yasu.ccsapi.Domain.Entity.ApiUserListEntity;
import com.yasu.ccsapi.Domain.Entity.CcsUserEntity;
import com.yasu.ccsapi.Domain.Repository.ApiListRepository;
import com.yasu.ccsapi.Domain.Repository.ApiUserListRepository;
import com.yasu.ccsapi.Domain.Repository.ApiUserRepository;
import com.yasu.ccsapi.Domain.Repository.CcsUserRepository;
import com.yasu.ccsapi.ErrorCords;
import com.yasu.ccsapi.security.CryptoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {

    @Autowired
    private CcsUserRepository ccsUserRepository;
    @Autowired
    private ApiUserRepository apiUserRepository;
    @Autowired
    private ApiUserListRepository userListRepository;
    @Autowired
    private ApiListRepository apiListRepository;

    private CryptoManager cryptoManager;

    public String decrypt(String key, Integer studNum) {
        try {
            return cryptoManager.decrypt(key, String.valueOf(studNum));
        } catch (Exception e) {
            return null;
        }
    }

    public String auth(String decryptedKey, Integer studNum) {
        // API KEY 구조 : {회원 ID}/{API ID}
        // API KEY 에 대한 복호화 키 : {학번}
        String[] strings = decryptedKey.split("/");

        // 학번 으로 CCS 계정 조회
        CcsUserEntity findCcsUser = ccsUserRepository.findByStudNum(studNum);
        ApiUserEntity findApiUser = apiUserRepository.findByStudNum(studNum);
        if(findCcsUser==null || findApiUser==null) // 계정 유효성 검사
            return "ERR_USER_NOT_FOUND";
        else if(!findCcsUser.getId().equals(strings[0])) // KEY 의 ID와 학번 으로 조회 한 계정의 ID 검사
            return "ERR_KEY_NOT_MATCH";

        ApiListEntity apiList = apiListRepository.findById(strings[1]); // API 유효성 검사
        if (apiList==null)
            return "ERR_API_NOT_FOUND";

        return "OK";
    }

    public String getApiName(String decryptedKey) {
        return apiListRepository.findById(decryptedKey.split("/")[1]).getName();
    }

    public String getApiKey(Integer studNum, String apiName) {
        return userListRepository.findByUserStudNumAndListName(studNum, apiName).getApiKey();
    }

    public List<ErrorDto> makeErrorMsg(ErrorCords cord) {
        List<ErrorDto> error = new ArrayList<>();
        error.add(ErrorDto.builder().errorCode(cord).build());
        return error;
    }

}
