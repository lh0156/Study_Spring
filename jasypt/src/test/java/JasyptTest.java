import jasypt.Config;
import org.assertj.core.api.Assertions;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = jasypt.Config.class)
@EnableConfigurationProperties( jasypt.Config.class)
public class JasyptTest {

    @Autowired
    private Config config;

    @Test
    public void Encryptor() {

        String password = config.getPassword();
        PooledPBEStringEncryptor encryptor;

        if (config.getAlgorithm().equals("1")) {
            //PBEWithMD5AndDES 알고리즘 사용
            encryptor = new PooledPBEStringEncryptor();
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

        } else if (config.getAlgorithm().equals("2")) {
            //PBEWithSHA256And128BitAES 알고리즘
            encryptor = new PooledPBEStringEncryptor();

            encryptor.setAlgorithm("PBEWithSHA256And128BitAES-CBC-BC"); // 사용 알고리즘
            encryptor.setProvider(new BouncyCastleProvider());
            encryptor.setPoolSize(2); // 암호화 요청의 pool 크기. 2를 권장
            encryptor.setPassword(password); // 암호화 키

        } else {
            System.out.println("유효하지 않은 설정값입니다");
            return;
        }

        String temp = "테스트 문장입니다";
        String isEncrypt = encryptor.encrypt(temp);
        String isDecrypt = encryptor.decrypt(isEncrypt);

        System.out.println("원문: " + temp);
        System.out.println("암호화: " + isEncrypt);
        System.out.println("복호화: " + isDecrypt);

        //확인
        Assertions.assertThat(temp).isEqualTo(isDecrypt);


    }// getEncryptor



}
