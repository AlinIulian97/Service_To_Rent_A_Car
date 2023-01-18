package beams.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    @GetMapping("/start")
    public String gotWelcomePage(){
        return "startPage";
    }

    @GetMapping("/menu")
    public String gotMenu(){
        return "menuPage";
    }
}
