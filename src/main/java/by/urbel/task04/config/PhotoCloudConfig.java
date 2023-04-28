package by.urbel.task04.config;

import com.uploadcare.api.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PhotoCloudConfig {
    @Value("${PHOTO_CLOUD_PK}")
    private String publicKey;
    @Value("${PHOTO_CLOUD_SK}")
    private String secretKey;

    @Bean
    public Client photoCloudClient() {
        return new Client(publicKey, secretKey);
    }
}
