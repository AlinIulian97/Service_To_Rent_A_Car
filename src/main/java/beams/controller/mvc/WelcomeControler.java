package beams.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeControler {
    @GetMapping("/start")
    public String gotWelcomePage(){
        return "StartPage";
    }
}
