package YmlConfig;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@ConfigurationProperties
public class AppConfig {

    @Value("${url}")
    private String URL;

    @Value("${key}")
    private String KEY;

    @Bean
    AppConfigSource AppSource() {
        return new AppConfigSource(URL, KEY);
    }

}
