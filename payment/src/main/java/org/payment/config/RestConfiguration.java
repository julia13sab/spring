package org.payment.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {

    @Value("${product.url}")
    private String productUrl;

    @Bean
    RestTemplate paymentRestTemplate() {
       return new RestTemplateBuilder()
               .rootUri(productUrl)
               .build();
    }
}
