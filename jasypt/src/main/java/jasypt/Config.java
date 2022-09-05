package jasypt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "demo")
public class Config {

//    @Value("${demo.password}")
    public String password;

//    @Value("${demo.algorithm}")
    public String algorithm;

}
