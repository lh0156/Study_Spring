//package aim.com.kr.jasypt;
//
//import org.bouncycastle.jce.provider.BouncyCastleProvider;
//import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
//import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import javax.crypto.SecretKeyFactory;
//import javax.crypto.spec.DESKeySpec;
//import java.security.Key;
//import java.util.Base64;
//
//@Component
//public class AppRunner implements CommandLineRunner {
//
//    @Autowired
//    private Config config;
//
//    @Override
//    public void run(String... args) throws Exception {
//        Encryptor("테스트");
//    }
//
//    public void Encryptor(String message) throws Exception {
//
//        String passcode = config.getPasscode();
//        String algorithm = config.getAlgorithm();
//        PooledPBEStringEncryptor encryptor = null;
//
//        System.out.println("passcode: " + passcode);
//        System.out.println("algorithm: " + algorithm);
//
//
//        if (algorithm.equals("1")) {
//            //PBEWithMD5AndDES 알고리즘 사용
//
//            if (encryptor == null) {
//                encryptor = new PooledPBEStringEncryptor();
//            }
//
//            SimpleStringPBEConfig config = new SimpleStringPBEConfig();
//            config.setPassword(passcode);
//            config.setAlgorithm("PBEWithMD5AndDES");
//            config.setKeyObtentionIterations("1000");
//            config.setPoolSize("1");
//            config.setProviderName("SunJCE");
//            config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
//            config.setIvGeneratorClassName("org.jasypt.iv.NoIvGenerator");
//            config.setStringOutputType("base64");
//            encryptor.setConfig(config);
//
//            String isEncrypt = encryptor.encrypt(message);
//            System.out.println(isEncrypt);
//
//        } else if (algorithm.equals("2")) {
//            //PBEWithSHA256And128BitAES 알고리즘
//
//            if (encryptor == null) {
//                encryptor = new PooledPBEStringEncryptor();
//            }
//            encryptor.setAlgorithm("PBEWithSHA256And128BitAES-CBC-BC"); // 사용 알고리즘
//            encryptor.setProvider(new BouncyCastleProvider());
//            encryptor.setPoolSize(2); // 암호화 요청의 pool 크기. 2를 권장
//            encryptor.setPassword(passcode); // 암호화 키
//
//            String isEncrypt = encryptor.encrypt(message);
//            System.out.println(isEncrypt);
//
//        } else if (algorithm.equals("3")){
//            DESKeySpec desKeySpec = new DESKeySpec(passcode.getBytes());
//            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
//            Key key = keyFactory.generateSecret(desKeySpec);
//
//            //그냥 Des인지 Triple Des 인지 에 따라 분기  passcode값이 24비트인경우 트리플 des로 앤크립트
//            String instance = (passcode.length() == 24) ? "DESede/ECB/PKCS5Padding" : "DES/ECB/PKCS5Padding";
//
//            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(instance);
//
//            cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, key);
//
//            byte[] inputBytes = message.getBytes("UTF8");
//            byte[] outputBytes = cipher.doFinal(inputBytes);
//
//            String s = Base64.getEncoder().encodeToString(outputBytes);
//
//            System.out.println(s);
//
//        }
//    }
//}
