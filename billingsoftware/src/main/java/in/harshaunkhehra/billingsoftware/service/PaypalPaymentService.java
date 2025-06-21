package in.harshaunkhehra.billingsoftware.service;

import java.util.List;

import in.harshaunkhehra.billingsoftware.io.PaypalPaymentRequest;
import in.harshaunkhehra.billingsoftware.io.PaypalPaymentResponse;

public interface PaypalPaymentService {

    PaypalPaymentResponse processPayment(PaypalPaymentRequest request);
    
    PaypalPaymentResponse getPaymentByOrderId(String orderId);
    
    PaypalPaymentResponse getPaymentByPaypalOrderId(String paypalOrderId);
    
    List<PaypalPaymentResponse> getAllPayments();
    
    List<PaypalPaymentResponse> getPaymentsByStatus(String status);
    
    void updatePaymentStatus(String orderId, String status);
} 