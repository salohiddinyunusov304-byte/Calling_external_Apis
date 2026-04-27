package uz.pdp.calling_external_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import uz.pdp.calling_external_api.payload.CurrencyRecord;

import java.util.List;

@RestController
@RequestMapping("/api/valyuta")
@RequiredArgsConstructor
public class ValyutaController {
    @Value("${valyuta-course}")
    private String valyutaCourseUrl;

    private final WebClient valyutaClient;

    @GetMapping("/all-courses")
    public List<CurrencyRecord> allCourses() {
        return valyutaClient.get()
                .uri(valyutaCourseUrl)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<CurrencyRecord>>() {})
                .block();
    }
}
