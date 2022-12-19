package beams.controller;

import beams.model.refund.RefundRequest;
import beams.model.refund.RefundResponse;
import beams.service.RefundService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("refund")
@RequiredArgsConstructor
public class RefundController {

    private final RefundService refundService;

    @PostMapping("/save")
    public RefundResponse saveRefund(@RequestBody RefundRequest refundRequest) {
        return refundService.saveRefund(refundRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteRefund(@PathVariable Integer id) {
        refundService.deleteRefund(id);
    }

    @GetMapping("/{id}")
    public RefundResponse findById(@PathVariable Integer id) {
        return refundService.findById(id);
    }

}
