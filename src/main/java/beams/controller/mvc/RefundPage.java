package beams.controller.mvc;

import beams.model.refund.RefundRequest;
import beams.service.RefundService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RefundPage {

    private final RefundService refundService;

    @GetMapping("/refundPage")
    public String goToRefundPage() {
        return "refundPage";
    }

    @PostMapping("/createRefund")
    public String createRefund(@ModelAttribute(value = "refund") RefundRequest request,
                               Model model) {
        RefundRequest refundRequest = RefundRequest.builder()
                .comments(request.getComments())
                .employeeId(request.getEmployeeId())
                .reservationId(request.getReservationId())
                .surcharge(request.getSurcharge())
                .returnDate(request.getReturnDate())
                .build();
        refundService.saveRefund(refundRequest);
        model.addAttribute("refund", refundService.refunds());
        return "allRefundPage";
    }

    @GetMapping("/listRefund")
    public String getAllRefund(Model model){
        model.addAttribute("refund" , refundService.refunds());
        return "allRefundPage";
    }


}
