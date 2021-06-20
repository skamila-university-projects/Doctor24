package skamila.doctor24.pdfprescription.config;

import feign.RequestInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

@Configuration
public class FeignClientConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "security.oauth2.client")
    public ResourceOwnerPasswordResourceDetails resourceOwnerPasswordResourceDetails() {
        ResourceOwnerPasswordResourceDetails res =  new ResourceOwnerPasswordResourceDetails();
        res.setPassword("admin");
        res.setUsername("admin");
        res.setClientId("doctor-24");
        res.setClientSecret("doctor-24");
        res.setGrantType("password");
        res.setAccessTokenUri("http://localhost:8888/oauth/token");
        return res;
    }

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor(){
        return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), resourceOwnerPasswordResourceDetails());
    }

    @Bean
    public OAuth2RestTemplate clientCredentialsRestTemplate() {
        return new OAuth2RestTemplate(resourceOwnerPasswordResourceDetails());
    }

}
