package sda.covidapp.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello/{langCode}")
    public String helloWorldInfo(@PathVariable String langCode, @RequestParam String name) {
        String greetings = "";
        switch (langCode.toUpperCase()) {
            case "EN":
                greetings = "Hello World";
                break;
            case "ES":
                greetings = "Hola";
                break;
            case "PL":
                greetings = "Witaj świecie";
                break;
            default:
                return "Unknown lang";
        }
        return greetings + " " + name;
    }


}
