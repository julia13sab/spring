package org.payment.config;

import org.payment.exception.RestTemplateResponseErrorHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestConfiguration {

    @Value("${product.url}")
    private String productUrl;

    @Value("${product.connectTimeout}")
    private Long connectTimeout;

    @Value("${product.readTimeout}")
    private Long readTimeout;


    @Bean
    RestTemplate paymentRestTemplate(RestTemplateResponseErrorHandler restTemplateResponseErrorHandler) {
       return new RestTemplateBuilder()
               .rootUri(productUrl)
               .setConnectTimeout(Duration.ofMillis(connectTimeout))
               .setReadTimeout(Duration.ofMillis(readTimeout))
               .errorHandler(restTemplateResponseErrorHandler)
               .build();
    }
}
