package in.harshaunkhehra.billingsoftware.service;

import java.util.List;

import in.harshaunkhehra.billingsoftware.io.OrderRequest;
import in.harshaunkhehra.billingsoftware.io.OrderResponse;

public interface OrderService {

    OrderResponse createOrder(OrderRequest request);

    void deleteOrder(String orderId);
    
    List<OrderResponse> getLatestOrders();
}
