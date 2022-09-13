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

import kr.co.aim.platform.framework.utility.common.Sha256Utils;
import org.junit.jupiter.api.Test;

/*
 *
 *****************************************************************************
 * PACKAGE : kr.co.aim.platform.framework.Sha256Test;
 * NAME : Sha256Test
 * Description : 사용자가 값을 Sha256으로 암호화하는 단방향 알고리즘 테스트 파일입니다.
 *
 *****************************************************************************
 */
public class Sha256Test {

    @Test
    public void Sha256Test() throws Exception {
        String message = "테스트 메세지입니다";
        String encryptMessage = Sha256Utils.Encryptor(message);

        System.out.println("원본 메세지: " + message);
        System.out.println("암호화 메세지: " + encryptMessage);
    }

}
