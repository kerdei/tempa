package hu.kerdei.tempa.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController {
    @GetMapping("/startMapping")
    String helloMapping() {
        return "Hello Tempa";
    }

}
