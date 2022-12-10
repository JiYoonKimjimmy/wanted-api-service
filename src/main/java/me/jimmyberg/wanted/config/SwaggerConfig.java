package me.jimmyberg.wanted.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("WANTED 채용 공고 검색 API")
                .description("원티드 채용 공고 검색 API 문서")
                .version("v0.0.1");

        return new OpenAPI()
                .info(info);
    }

}
