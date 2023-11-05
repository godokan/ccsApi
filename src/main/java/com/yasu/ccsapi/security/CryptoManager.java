package com.yasu.ccsapi.security;

import lombok.NoArgsConstructor;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

@NoArgsConstructor
public class CryptoManager {
    private final String IV = "265cfc162cfdf7c3";

    public String encrypt(String plaintext, String key) throws Exception{
        // 랜덤한 salt 생성
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        SecretKeySpec secretKeySpec = getKeySpec(key, salt);

        // 암호화 준비
        byte[] iv=IV.getBytes();
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

        // 평문을 암호화
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());

        // 암호화된 데이터와 salt를 Base64로 인코딩하여 반환
        String saltString = Base64.getEncoder().encodeToString(salt);
        String encryptedString = Base64.getEncoder().encodeToString(encryptedBytes);
        return saltString + ":" + encryptedString;
    }

    public String decrypt(String ciphertext, String key) throws Exception {
        // 입력된 암호문을 salt와 암호화된 데이터로 분리
        String[] parts = ciphertext.split(":");
        byte[] salt = Base64.getDecoder().decode(parts[0]);
        byte[] encryptedBytes = Base64.getDecoder().decode(parts[1]);

        // 입력된 키 문자열을 기반으로 SecretKey 생성
        SecretKeySpec secretKeySpec = getKeySpec(key, salt);

        // 복호화 준비
        byte[] iv=IV.getBytes();
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec,ivParameterSpec);

        // 암호문을 복호화
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        // 평문으로 복호화된 데이터 반환
        return new String(decryptedBytes);
    }

    private SecretKeySpec getKeySpec(String key, byte[] salt) throws Exception {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        PBEKeySpec spec = new PBEKeySpec(key.toCharArray(), salt, 65536, 256);
        SecretKey secretKey = factory.generateSecret(spec);
        return new SecretKeySpec(secretKey.getEncoded(), "AES");
    }
}