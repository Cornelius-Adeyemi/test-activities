package org.example;

import com.google.gson.Gson;
import netscape.javascript.JSObject;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Algorithm {


    public static void main(String ...arg){
       String secretKey = "B8E549FE404520CF065364D861CC5C21A11F8BA515CE29DE";
       String mobile = "08069493991";

       String key =  "b9509ea475e27fb8e1656f28c7e5d8ade52c71f0";
        System.out.println(key.substring(0,16).getBytes());
        step4Dto step4Dto = new step4Dto();
        step4Dto.setSecretKey(secretKey);
        step4Dto.setMobile(mobile);

        System.out.println(generateSHA1(secretKey));
//
//        Gson gson = new Gson();
//
//       String object = gson.toJson(step4Dto);
//String encryption = encrypt(object.getBytes(),key.substring(0,16).getBytes(),key.substring(0,16).getBytes());
//        System.out.println( encryption);
//
//        System.out.println(decrypt(encryption,key.substring(0,16).getBytes(),key.substring(0,16).getBytes()));


    }

    public static String encrypt(byte[] dataToEncrypt, byte[] key, byte[] iv) {
        try {
            // Initialize the AES Cipher object
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // Java uses PKCS5Padding

            // Create the key and IV specifications
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

            // Initialize the cipher for encryption
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

            // Perform encryption
            byte[] encryptedData = cipher.doFinal(dataToEncrypt);

            // Convert encrypted data to hex string
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : encryptedData) {
                stringBuilder.append(String.format("%02X", b));
            }

            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static String decrypt(String dataToDecrypt, byte[] key, byte[] iv) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

            // Convert hex string to byte array
            byte[] encryptedData = hexStringToByteArray(dataToDecrypt);

            // Decrypt the data
            byte[] decryptedData = cipher.doFinal(encryptedData);
            return new String(decryptedData);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Helper method to convert hex string to byte array
    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }


    public static String generateSHA1(String input) {
        try {
            // Get an instance of the SHA-1 message digest
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            // Digest the input string and get the hash's bytes
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert the byte array into a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            // Return the hexadecimal string
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
