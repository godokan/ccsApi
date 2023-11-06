package com.yasu.ccsapi.controller;

import com.yasu.ccsapi.DTO.ApiUserDto;
import com.yasu.ccsapi.Domain.Repository.ApiUserRepository;
import com.yasu.ccsapi.security.CryptoManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @Autowired
    private ApiUserRepository userRepository;

    @GetMapping("/issue")
    public String issueKey(@RequestParam String id, @RequestParam Integer stdNum, @RequestParam String apiName) throws Exception {
        // API KEY 구조 : {회원ID}/{API이름}
        // API KEY 에 대한 복호화 키 : {학번}

        String issued;
        CryptoManager manager = new CryptoManager();
        issued = manager.encrypt(id+"/"+apiName, String.valueOf(stdNum));

        ApiUserDto userDto = ApiUserDto.builder()
                .api_key(issued)
                .studNum(stdNum)
                .build();

        log.info("API KEY ISSUED : "+userDto.getApi_key() + "/" + userDto.getStudNum());

        userRepository.save(userDto.toEntity());

        return issued;
    }


}
