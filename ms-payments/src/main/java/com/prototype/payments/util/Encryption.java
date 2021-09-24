package com.prototype.payments.util;

import com.prototype.payments.constant.PaymentMessages;
import com.prototype.payments.exception.PaymentNotFoundException;
import com.prototype.payments.exception.PaymentServerErrorException;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

@Slf4j
public class Encryption {


    private static SecretKeySpec secretKey;
    private static byte[] key;
    private static String secret = "Bar12345Bar12345";

    public static void setKey(String myKey) throws PaymentServerErrorException {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
         log.error("Se presento un error en setKey {}" , e.getMessage());
         throw  new PaymentServerErrorException(PaymentMessages.DESCP0004);
        }

    }

    public static String encrypt(String strToEncrypt) throws PaymentServerErrorException {
       try {
           setKey(secret);
           Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
           cipher.init(Cipher.ENCRYPT_MODE, secretKey);
           return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));

       }catch (Exception  e){
           log.error("Se presento en encrypt {}" , e.getMessage());
           throw  new PaymentServerErrorException(PaymentMessages.DESCP0004);
        }

    }



}
