package in.harshaunkhehra.billingsoftware.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.harshaunkhehra.billingsoftware.entity.PaypalPaymentEntity;

@Repository
public interface PaypalPaymentRepository extends JpaRepository<PaypalPaymentEntity, Long> {
    
    Optional<PaypalPaymentEntity> findByOrderId(String orderId);
    
    Optional<PaypalPaymentEntity> findByPaypalOrderId(String paypalOrderId);
    
    Optional<PaypalPaymentEntity> findByPaypalPaymentId(String paypalPaymentId);
    
    List<PaypalPaymentEntity> findAllByOrderByCreatedAtDesc();
    
    List<PaypalPaymentEntity> findByPaymentStatus(PaypalPaymentEntity.PaymentStatus status);
} 