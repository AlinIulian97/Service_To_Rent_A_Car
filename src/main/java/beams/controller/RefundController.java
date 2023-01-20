package beams.controller;

import beams.model.refund.RefundRequest;
import beams.model.refund.RefundResponse;
import beams.model.refund.RefundUpdateResponse;
import beams.service.RefundService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PatchMapping({"{id}"})
    public void updateRefund(@PathVariable Integer id , @RequestBody  RefundUpdateResponse refundUpdateResponse){
        refundService.updateRefund(id , refundUpdateResponse);
    }

    @GetMapping("/list")
    public List<RefundResponse> refundResponseList(){
        return refundService.refunds();
    }

}
