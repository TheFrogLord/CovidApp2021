package sda.covidapp.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello/{langCode}")
    public String helloWorldInfo(@PathVariable String langCode) {
        switch (langCode.toUpperCase()) {
            case "EN":
                return "Hello World";
            case "ES":
                return "Hola";
            case "PL":
                return "Witaj świecie";
            default:
                return "Unknown lang";
        }
    }




}
