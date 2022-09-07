package jasypt;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties(prefix = "demo")
public class Config {


    public String getPassword() {
        return password;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    @Value("${password}")
    public String password;

    @Value("${algorithm}")
    public String algorithm;

}
