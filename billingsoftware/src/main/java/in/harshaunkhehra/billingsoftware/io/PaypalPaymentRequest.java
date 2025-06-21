package in.harshaunkhehra.billingsoftware.io;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaypalPaymentRequest {
    private String customerName;
    private String phoneNumber;
    private Double subtotal;
    private Double tax;
    private Double total;
    private List<OrderRequest.OrderItemRequest> items;
    private String paypalOrderId;
    private String paypalPaymentId;
    private String paypalPayerId;
} 