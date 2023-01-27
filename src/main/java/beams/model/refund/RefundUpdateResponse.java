package beams.model.refund;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RefundUpdateResponse {

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDate returnDate;

    private Double surcharge;

}
