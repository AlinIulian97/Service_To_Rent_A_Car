package beams.controller;

import beams.model.branch.BranchDetailsResponse;
import beams.model.branch.BranchRequest;
import beams.model.branch.BranchResponse;
import beams.model.branch.BranchToUpdate;
import beams.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("branch")
@RequiredArgsConstructor
public class BranchController {

    private final BranchService branchService;

    @PostMapping("/save")
    public BranchResponse branchResponse(@RequestBody BranchRequest branchRequest) {
        return branchService.saveBranch(branchRequest);
    }

    @GetMapping("/{id}")
    public BranchResponse findById(@PathVariable Integer id) {
        return branchService.findById(id);
    }

    @GetMapping("/{id}/details")
    public BranchDetailsResponse findByIdWithDetails(@PathVariable Integer id) {
        return branchService.findByIdWithDetails(id);
    }

    @PatchMapping("{id}")
    public void updateBranch(@PathVariable Integer id , @RequestBody BranchToUpdate branchToUpdate){
        branchService.updateBranch(id ,branchToUpdate);
    }
}
