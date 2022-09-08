/*
 ****************************************************************************
 *
 *  (c) Copyright aim All rights reserved.
 *
 *  This software is proprietary to and embodies the confidential
 *  technology of aim Possession, use, or copying of this
 *  software and media is authorized only pursuant to a valid written
 *  license from aim systems, Inc.
 *
 ****************************************************************************
 */

package aim.com.kr.jasypt.PojoUtilDemo;

import static aim.com.kr.jasypt.PojoJavaUtil.EncryptUtilPojo.decryptPBE;

public class PBEWithHmacSHA256AndAES_128Demo {

    public static void main(String[] args) throws Exception {

        /*
            PBEWithHmacSHA256AndAES_128 알고리즘 사용
        */
        String message = "암호화 할 메세지입니다.";
        String isEncrypt = decryptPBE(message);

        System.out.println("원문 메세지: " + message);
        System.out.println("암호화 메세지: " + isEncrypt);

    }

}
