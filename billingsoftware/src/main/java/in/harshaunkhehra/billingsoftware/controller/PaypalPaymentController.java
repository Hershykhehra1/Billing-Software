package in.harshaunkhehra.billingsoftware.controller;

import in.harshaunkhehra.billingsoftware.io.PaypalPaymentRequest;
import in.harshaunkhehra.billingsoftware.io.PaypalPaymentResponse;
import in.harshaunkhehra.billingsoftware.service.PaypalPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paypal-payments")
@RequiredArgsConstructor
public class PaypalPaymentController {

    private final PaypalPaymentService paypalPaymentService;

    @PostMapping("/process")
    @ResponseStatus(HttpStatus.CREATED)
    public PaypalPaymentResponse processPayment(@RequestBody PaypalPaymentRequest request) {
        return paypalPaymentService.processPayment(request);
    }

    @GetMapping("/{orderId}")
    public PaypalPaymentResponse getPaymentByOrderId(@PathVariable String orderId) {
        return paypalPaymentService.getPaymentByOrderId(orderId);
    }

    @GetMapping("/paypal-order/{paypalOrderId}")
    public PaypalPaymentResponse getPaymentByPaypalOrderId(@PathVariable String paypalOrderId) {
        return paypalPaymentService.getPaymentByPaypalOrderId(paypalOrderId);
    }

    @GetMapping
    public List<PaypalPaymentResponse> getAllPayments() {
        return paypalPaymentService.getAllPayments();
    }

    @GetMapping("/status/{status}")
    public List<PaypalPaymentResponse> getPaymentsByStatus(@PathVariable String status) {
        return paypalPaymentService.getPaymentsByStatus(status);
    }

    @PutMapping("/{orderId}/status")
    public void updatePaymentStatus(@PathVariable String orderId, @RequestParam String status) {
        paypalPaymentService.updatePaymentStatus(orderId, status);
    }
} 