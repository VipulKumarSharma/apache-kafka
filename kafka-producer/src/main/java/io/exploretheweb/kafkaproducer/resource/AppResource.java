package io.exploretheweb.kafkaproducer.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppResource {

    @Value("${app.name}")
    private String appName;

    @GetMapping("/")
    public String getAppStatus() {
        return appName+" is in running status";
    }

}
