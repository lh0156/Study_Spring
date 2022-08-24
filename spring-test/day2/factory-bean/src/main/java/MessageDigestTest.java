import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestTest {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        //암호화 알고리즘 MD5, SHA1, SHA-128, SHA-256
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        String msg = "ILoveYou";
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

        System.out.println(hexString);
    }
}
