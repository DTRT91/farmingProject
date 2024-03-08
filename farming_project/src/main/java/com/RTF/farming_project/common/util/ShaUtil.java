//package com.RTF.farming_project.common.util;
//
//import com.google.common.hash.Hashing;
//
//import java.nio.charset.StandardCharsets;
//import java.security.SecureRandom;
//import java.util.Base64;
//
//public class ShaUtil {
//
//    public static final SecureRandom random = new SecureRandom();
//
//    public static String getSalt() {
//
//        byte[] salt = new byte[16];
//        random.nextBytes(salt);
//
//        return Base64.getEncoder().encodeToString(salt);
//    }
//
//    public static String sha256Encode(String plainText, String plainSalt){
//        return Hashing.sha256()
//                .hashString(plainText + plainSalt, StandardCharsets.UTF_8)
//                .toString();
//    }
//}
