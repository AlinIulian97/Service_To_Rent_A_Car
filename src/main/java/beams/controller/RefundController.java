package beams.controller;

import beams.model.refund.RefundRequest;
import beams.model.refund.RefundResponse;
import beams.service.RefundService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RefundController {

    private final RefundService refundService;

    @PostMapping("/saveRefund")
    public RefundResponse saveRefund (@RequestBody RefundRequest refundRequest){
        return refundService.saveRefund(refundRequest);

    }
}
