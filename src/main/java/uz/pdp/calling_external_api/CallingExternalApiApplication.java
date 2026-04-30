package uz.pdp.calling_external_api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.HttpHeaders;

import java.util.List;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Working with Calling external Api| G58 Open Specification | Swagger",
                version = "1.0",
                description = "Rest template",
                contact = @Contact(
                        name = "Salohiddin Yunusov",
                        email = "salohiddinyunusov377@gmail.com"
                ),
                license = @License(
                        name = "MIT License",
                        url = "https://opensource.org/licenses/MIT"
                )
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "Local Server"
                )
        }
)
@ConfigurationPropertiesScan
@EnableFeignClients
public class CallingExternalApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CallingExternalApiApplication.class, args);
    }

    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Spring Swagger Example")
                        .description("Spring Boot + Swagger + MapStruct Example")
                        .version("1.0")
                        .contact(new io.swagger.v3.oas.models.info.Contact()
                                .name("Salohiddin Yunusov")
                                .email("salohiddinyunusov377@gmail.com")
                                .url("https://github.com"))
                        .license(new io.swagger.v3.oas.models.info.License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org"))
                        .termsOfService("http://swagger.io/terms/"))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentation")
                        .url("https://springdoc.org"))
                .servers(List.of(
                        new io.swagger.v3.oas.models.servers.Server()
                                .url("http://localhost:8080")
                                .description("Production"),
                        new io.swagger.v3.oas.models.servers.Server()
                                .url("http://localhost:9090")
                                .description("Test Server")
                ));
    }

    @Bean(name = "valyutaClient")
    public WebClient valyutaClient() {
        return WebClient.builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }


}
