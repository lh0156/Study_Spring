/*
 ****************************************************************************
 *
 * (c) Copyright aim All rights reserved.
 *
 * This software is proprietary to and embodies the confidential
 * technology of aim Possession, use, or copying of this
 * software and media is authorized only pursuant to a valid written
 * license from aim systems, Inc.
 *
 ****************************************************************************
 */

package aim.com.kr.jasypt;

import java.security.MessageDigest;

/*
 *
 *****************************************************************************
 * PACKAGE :kr.co.aim.platform.framework.utility.common
 * NAME : EncyprtUil
 * Description : Sha256 알고리즘으로 암호화하는 Util입니다.
 *
 *****************************************************************************
 */
public class Sha256Utils {

    /***
     *
     * @param
     * message to be encrypted
     * @throws Exception
     */
    public static String Encryptor(String message) throws Exception {
        final char[] hexArray = "0123456789abcdef".toCharArray();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(message.getBytes());

            byte[] bytes = md.digest();
            char[] hexChars = new char[bytes.length * 2];
            for (int i = 0; i < bytes.length; ++i) {
                int v = bytes[i] & 0xFF;

                hexChars[i * 2] = hexArray[v >>> 4];
                hexChars[i * 2 + 1] = hexArray[v & 0x0F];
            }
            return new String(hexChars);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

}
