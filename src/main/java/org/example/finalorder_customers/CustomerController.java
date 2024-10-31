package org.example.finalorder_customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/cust")
public class CustomerController {
    @Autowired
    private CustomerRepo customerRepo;
    @PostMapping
    public String createCustomer(@RequestBody Customer customer) {
        customerRepo.save(customer);
        System.out.println(customer.toString());
        return "SAVED";
    }
    @GetMapping("/{id}")
    public String getInfo(@PathVariable long id) {
        Customer customer = customerRepo.findById(id).get();
        System.out.println(customer.toString());
        Set<Order> ord=customer.getOrders();
        for(Order o:ord){
            System.out.println(o.toString());
        }

        return customer.toString();
    }

}
