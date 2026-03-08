package com.company.system.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

public class UserUtil {
    public static String cryptography(String _password) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);
            SecretKey secretKey = keyGenerator.generateKey();

            byte[] iv = new byte[16];
            new SecureRandom().nextBytes(iv);
            IvParameterSpec ivSpec = new IvParameterSpec(iv);

            Cipher cipherAES = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipherAES.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
            byte[] encryptedBytes = cipherAES.doFinal(_password.getBytes());

            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return _password;
    }
}
