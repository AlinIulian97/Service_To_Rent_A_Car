package beams.controller;

import beams.model.revenue.RevenueRequest;
import beams.model.revenue.RevenueResponse;
import beams.service.RevenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("revenue")
public class RevenueController {
    private final RevenueService revenueService;

    @PostMapping("/save")
    public RevenueResponse saveRevenue(@RequestBody RevenueRequest revenueRequest) {
        return revenueService.addRevenue(revenueRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteRevenue(@PathVariable Integer id) {
        revenueService.deleteRevenue(id);
    }
}
