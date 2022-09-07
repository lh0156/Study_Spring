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

package jasypt;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {

    @Value("${jasypt.encryptor.password}")
    private String password;

    @Bean("PBEWithMD5AndDES")
    public StringEncryptor PBEEncrypt() {

        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(password);
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.NoIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
    }

    @Bean("PBEWithSHA256And128BitAES-CBC-BC")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();

        encryptor.setAlgorithm("PBEWithSHA256And128BitAES-CBC-BC"); // 사용 알고리즘
        encryptor.setProvider(new BouncyCastleProvider());
        encryptor.setPoolSize(2); // 암호화 요청의 pool 크기. 2를 권장
        encryptor.setPassword("password"); // 암호화 키

        return encryptor;
    }
}