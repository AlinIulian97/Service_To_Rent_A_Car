package beams.model.rental;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentalUpdateResponse {

    private Integer id;

    private String owner;

    private String contactAddress;

}
