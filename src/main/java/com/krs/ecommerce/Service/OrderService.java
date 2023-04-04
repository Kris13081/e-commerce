package com.krs.ecommerce.Service;

import com.krs.ecommerce.Model.Customer;
import com.krs.ecommerce.Model.Order;
import com.krs.ecommerce.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public long countOrders() {
        return orderRepository.count();
    }

    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }

    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
