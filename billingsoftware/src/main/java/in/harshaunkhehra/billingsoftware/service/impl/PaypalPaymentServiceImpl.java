package in.harshaunkhehra.billingsoftware.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import in.harshaunkhehra.billingsoftware.entity.OrderItemEntity;
import in.harshaunkhehra.billingsoftware.entity.PaypalPaymentEntity;
import in.harshaunkhehra.billingsoftware.io.OrderRequest;
import in.harshaunkhehra.billingsoftware.io.PaypalPaymentRequest;
import in.harshaunkhehra.billingsoftware.io.PaypalPaymentResponse;
import in.harshaunkhehra.billingsoftware.repository.PaypalPaymentRepository;
import in.harshaunkhehra.billingsoftware.service.PaypalPaymentService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaypalPaymentServiceImpl implements PaypalPaymentService {

    private final PaypalPaymentRepository paypalPaymentRepository;

    @Override
    public PaypalPaymentResponse processPayment(PaypalPaymentRequest request) {
        PaypalPaymentEntity paymentEntity = PaypalPaymentEntity.builder()
                .customerName(request.getCustomerName())
                .phoneNumber(request.getPhoneNumber())
                .subtotal(request.getSubtotal())
                .tax(request.getTax())
                .total(request.getTotal())
                .paypalOrderId(request.getPaypalOrderId())
                .paypalPaymentId(request.getPaypalPaymentId())
                .paypalPayerId(request.getPaypalPayerId())
                .paymentStatus(PaypalPaymentEntity.PaymentStatus.COMPLETED)
                .items(convertToOrderItemEntities(request.getItems()))
                .build();

        PaypalPaymentEntity savedPayment = paypalPaymentRepository.save(paymentEntity);
        return convertToResponse(savedPayment);
    }

    @Override
    public PaypalPaymentResponse getPaymentByOrderId(String orderId) {
        return paypalPaymentRepository.findByOrderId(orderId)
                .map(this::convertToResponse)
                .orElse(null);
    }

    @Override
    public PaypalPaymentResponse getPaymentByPaypalOrderId(String paypalOrderId) {
        return paypalPaymentRepository.findByPaypalOrderId(paypalOrderId)
                .map(this::convertToResponse)
                .orElse(null);
    }

    @Override
    public List<PaypalPaymentResponse> getAllPayments() {
        return paypalPaymentRepository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<PaypalPaymentResponse> getPaymentsByStatus(String status) {
        PaypalPaymentEntity.PaymentStatus paymentStatus = PaypalPaymentEntity.PaymentStatus.valueOf(status.toUpperCase());
        return paypalPaymentRepository.findByPaymentStatus(paymentStatus)
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void updatePaymentStatus(String orderId, String status) {
        paypalPaymentRepository.findByOrderId(orderId)
                .ifPresent(payment -> {
                    payment.setPaymentStatus(PaypalPaymentEntity.PaymentStatus.valueOf(status.toUpperCase()));
                    paypalPaymentRepository.save(payment);
                });
    }

    private List<OrderItemEntity> convertToOrderItemEntities(List<OrderRequest.OrderItemRequest> items) {
        return items.stream()
                .map(item -> OrderItemEntity.builder()
                        .itemId(item.getItemId())
                        .name(item.getName())
                        .price(item.getPrice())
                        .quantity(item.getQuantity())
                        .build())
                .collect(Collectors.toList());
    }

    private PaypalPaymentResponse convertToResponse(PaypalPaymentEntity entity) {
        return PaypalPaymentResponse.builder()
                .orderId(entity.getOrderId())
                .customerName(entity.getCustomerName())
                .phoneNumber(entity.getPhoneNumber())
                .subtotal(entity.getSubtotal())
                .tax(entity.getTax())
                .total(entity.getTotal())
                .paypalOrderId(entity.getPaypalOrderId())
                .paypalPaymentId(entity.getPaypalPaymentId())
                .paypalPayerId(entity.getPaypalPayerId())
                .paymentStatus(entity.getPaymentStatus().name())
                .createdAt(entity.getCreatedAt())
                .build();
    }
} 