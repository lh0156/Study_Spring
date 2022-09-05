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

import JasyptConfig;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SHA256And128BitAES {
    @Test
    public void SHA256And128BitAESEncrypt() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(JasyptConfig.class);
        StringEncryptor jasyptStringEncryptor = ac.getBean("PBEWithSHA256And128BitAES-CBC-BC", StringEncryptor.class);

        String message = "암호화 할 메세지입니다";
        String isEncrypt = jasyptStringEncryptor.encrypt(message);
        String isDecrypt = jasyptStringEncryptor.decrypt(isEncrypt);

        System.out.println("원문 메세지: " + message);
        System.out.println("암호화 메세지: " + isEncrypt);
        System.out.println("복호화 메세지: " + isDecrypt);
    }
}
