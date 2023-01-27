package beams.controller.mvc;

import beams.model.branch.BranchRequest;
import beams.model.rental.RentalRequest;
import beams.repository.RentalRepository;
import beams.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BranchWebController {

    private final BranchService branchService;
    private final RentalRepository rentalRepository;


    @GetMapping("/branch")
    public String goToBranchPage() {
        return "branchPage";
    }

    @PostMapping("/createBranch")
    public String createBranch(@ModelAttribute(value = "createBranch") BranchRequest request,
                               Model model) {
        BranchRequest branchRequest = BranchRequest.builder().
                addressCity(request.getAddressCity())
                .rentalId(request.getRentalId())
                .build();
        branchService.saveBranch(branchRequest);

        model.addAttribute("branches", branchService.branches());
        return "allBranchesPage";
    }

    @GetMapping("/listBranches")
    public String viewAllBranches(Model model){
        model.addAttribute("branches" , branchService.branches());
        return "allBranchesPage";
    }

    @PostMapping("/deleteBranch")
    public String deleteBranch(@ModelAttribute("deleteRequest")
                             BranchRequest branchRequest,
                             Model model) {

        branchService.deleteBranch(branchRequest.getId());
        model.addAttribute("branches", branchService.branches());
        return "allBranchesPage";
    }
}
