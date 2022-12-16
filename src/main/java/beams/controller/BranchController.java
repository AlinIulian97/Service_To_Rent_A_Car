package beams.controller;

import beams.model.branch.BranchRequest;
import beams.model.branch.BranchResponse;
import beams.service.BranchService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BranchController {

    private final BranchService branchService;

    @PostMapping("/saveBranch")
    private BranchResponse branchResponse(@RequestBody BranchRequest branchRequest){
        return branchService.saveBranch(branchRequest);

    }
}
