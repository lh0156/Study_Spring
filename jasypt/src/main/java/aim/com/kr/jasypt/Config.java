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


import lombok.Data;
import org.springframework.stereotype.Component;

/*
 *
 *****************************************************************************
 * PACKAGE : kr.co.aim.platform.framework.utility.common;
 * NAME : Config
 * Description : 사용자가 입력한 yml 파일의 property를 변수로 치환(할당)한 클래스입니다.
 *
 *****************************************************************************

 */
@Component
@Data
//@ConfigurationProperties(prefix = "util.encrypt")
public class Config {

    public String passcode;
    public String algorithm;

}
