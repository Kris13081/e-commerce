package com.krs.ecommerce.Service;


import com.krs.ecommerce.Model.OrderItem;
import com.krs.ecommerce.Repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public OrderItem saveOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
        return orderItem;
    }

    public OrderItem getOrderItem(Long id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    public Iterable<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public boolean existsOrderItem(Long id) {
        return orderItemRepository.existsById(id);
    }

    public long countOrderItems() {
        return orderItemRepository.count();
    }

    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }

}
