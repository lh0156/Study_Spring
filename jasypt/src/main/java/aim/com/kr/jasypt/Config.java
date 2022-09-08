package aim.com.kr.jasypt;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "demo")
public class Config {

    public String passcode;
    public String algorithm;

}
