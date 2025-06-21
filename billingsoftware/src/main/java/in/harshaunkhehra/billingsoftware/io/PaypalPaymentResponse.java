package in.harshaunkhehra.billingsoftware.io;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaypalPaymentResponse {
    private String orderId;
    private String customerName;
    private String phoneNumber;
    private Double subtotal;
    private Double tax;
    private Double total;
    private String paypalOrderId;
    private String paypalPaymentId;
    private String paypalPayerId;
    private String paymentStatus;
    private LocalDateTime createdAt;
} 