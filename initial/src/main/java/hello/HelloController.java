package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
        return "<html><head><h1>Greetings from Spring Boot!</h1></head><body>test</body></html>";
    }
    
}
