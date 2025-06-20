package in.harshaunkhehra.billingsoftware.io;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RazorpayOrderResponse {

    private String id;
    private String entity;
    private String amount;
    private String currency;
    private String status;
    private Date createdAt;
    private String receipt;
    
}
