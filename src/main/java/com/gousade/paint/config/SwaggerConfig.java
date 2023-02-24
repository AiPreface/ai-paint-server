package com.gousade.paint.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author woxigsd@gmail.com
 * @date 2020-8-25 16:54:43
 * <a href="http://springfox.github.io/springfox/docs/current/#configuration-explained">...</a>
 */
@EnableOpenApi
@Configuration
public class SwaggerConfig {

	/*@Value("${swagger.enable}")
	private boolean enable;*/

    @Bean
    public Docket publicApi(Environment environment) {
        Profiles profiles = Profiles.of("dev", "test");
        boolean enable = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.OAS_30).enable(enable).groupName("public").apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
    }

    @Bean
    public Docket adminApi(Environment environment) {
        Profiles profiles = Profiles.of("dev", "test");
        boolean enable = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.OAS_30).enable(enable).groupName("gousade").apiInfo(apiInfo()).select()
                //                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))//只显示被此注解标注的方法
                .apis(RequestHandlerSelectors.basePackage("com.gousade.paint.controller")).paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("ap-paint-server - v0.0.1 API")
                .description("Documentation Description")
                .contact(new Contact("ap-paint-server", "https://github.com/woxigousade/gousade", "woxigsd@gmail.com"))
                .version("v0.0.1").license("MIT License")
                .licenseUrl("https://github.com/ap-plugin/ai-paint-server/blob/main/LICENSE").build();
    }
}
