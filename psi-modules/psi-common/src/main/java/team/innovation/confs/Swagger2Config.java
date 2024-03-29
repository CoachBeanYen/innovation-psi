package team.innovation.confs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class Swagger2Config {
    private static final String SWAGGER_SCAN_BASE_PACKAGE = "team.innovation";
    private static final String VERSION = "0.0.1-SNAPSHOT";

    @Value("${innovation.swagger2.enable}")
    private boolean enable=false;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))//api接口包扫描路径
                .paths(PathSelectors.any())//可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build().enable(enable);
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Innovation PSI API DOC")
                .description("Innovation进销存API文档")
                .version(VERSION)
                .contact(new Contact("Bean Yen", "https://github.com/CoachBeanYen", "coachbeanyen@foxmail.com"))
                .build();
    }
}
