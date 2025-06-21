package in.harshaunkhehra.billingsoftware.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_paypal_payments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaypalPaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String orderId;
    private String customerName;
    private String phoneNumber;
    private Double subtotal;
    private Double tax;
    private Double total;
    private String paypalOrderId;
    private String paypalPaymentId;
    private String paypalPayerId;
    
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    
    private LocalDateTime createdAt;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "paypal_payment_id")
    private List<OrderItemEntity> items = new ArrayList<>();

    public enum PaymentStatus {
        PENDING, COMPLETED, FAILED
    }

    @PrePersist
    protected void onCreate() {
        this.orderId = "PAY" + System.currentTimeMillis();
        this.createdAt = LocalDateTime.now();
        if (this.paymentStatus == null) {
            this.paymentStatus = PaymentStatus.PENDING;
        }
    }
} 