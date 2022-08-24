package com.oraclejava.day2;

import java.security.MessageDigest;

public class MessageDigester {

    private MessageDigest messageDigest;

    public void setMessageDigest(MessageDigest messageDigest) {
        this.messageDigest = messageDigest;
    }

    //암호화(digest)
    public void digest(String msg) {
        digest(msg, messageDigest);
    }

    //오버로드
    public void digest(String msg, MessageDigest digest) {

        byte[] byteArray = msg.getBytes();
        byte[] hash = digest.digest(byteArray);
        //System.out.println(hash);

        StringBuffer hexString = new StringBuffer();

        for (int i=0; i<hash.length; ++i) {
            String hex = Integer.toHexString(0xff & hash[i]);

            if(hex.length() == 1) {
                hexString.append('0');
            }

            hexString.append(hex);
        }

        System.out.println(hexString.toString());
    }
}
