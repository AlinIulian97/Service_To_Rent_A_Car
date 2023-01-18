package beams.controller.mvc;

import beams.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BranchWebController {

   private final BranchService branchService;

   @GetMapping
    public String goToBranchPage(){
       return "branchPage";
   }


}
