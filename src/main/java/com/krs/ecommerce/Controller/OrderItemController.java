package com.krs.ecommerce.Controller;

import com.krs.ecommerce.Model.OrderItem;
import com.krs.ecommerce.Service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/orderItems")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @PostMapping
    public ResponseEntity<OrderItem> addOrderItem(OrderItem orderItem) {
        OrderItem newOrderItem = orderItemService.saveOrderItem(orderItem);
        return ResponseEntity.ok(newOrderItem);
    }

    @GetMapping
    public ResponseEntity<Iterable<OrderItem>> getAllOrderItems() {
        Iterable<OrderItem> orderItems = orderItemService.getAllOrderItems();
        return ResponseEntity.ok(orderItems);
    }

    @GetMapping("{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable("id") Long id) {
        OrderItem orderItem = orderItemService.getOrderItem(id);
        return ResponseEntity.ok(orderItem);
    }

    @PutMapping("{id}")
    public ResponseEntity<OrderItem> updateOrderItem(Long id, OrderItem orderItem) {
        OrderItem existingOrderItem = orderItemService.getOrderItem(id);
        if (existingOrderItem == null) {
            return ResponseEntity.notFound().build();
        }
        orderItem.setId(id);
        OrderItem updatedOrderItem = orderItemService.saveOrderItem(orderItem);
        return ResponseEntity.ok(updatedOrderItem);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteOrderItem(@PathVariable("id") Long id) {
        OrderItem orderItem = orderItemService.getOrderItem(id);
        if (orderItem == null) {
            return ResponseEntity.notFound().build();
        }
        orderItemService.deleteOrderItem(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countOrderItems() {
        Long count = orderItemService.countOrderItems();
        return ResponseEntity.ok(count);
    }

}
