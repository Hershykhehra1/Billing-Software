package in.harshaunkhehra.billingsoftware.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.harshaunkhehra.billingsoftware.entity.OrderItemEntity;

public interface OrderItemEntityRepository extends JpaRepository<OrderItemEntity, Long> {
    
}
