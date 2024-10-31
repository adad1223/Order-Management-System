package org.example.finalorder_customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @PostMapping
    public String createOrder(@RequestBody Order order) {
        orderRepo.save(order);
        return "Order created";
    }
    @PostMapping(value = "/{order_id}/{cust_id}")
    public String MapOrder(@PathVariable Long order_id, @PathVariable Long cust_id) {
        Optional<Order> order=orderRepo.findById(order_id);
        Optional<Customer> customer=customerRepo.findById(cust_id);
        if(order.isPresent() && customer.isPresent()) {
            order.get().setCustomer(customer.get());
            orderRepo.save(order.get());
        }
        return "Order Mapped";


    }

}
