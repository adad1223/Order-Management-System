package org.example.finalorder_customers;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="cust_id")
    private Long id;
    @Column(name="cust_name")
    private String name;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order>orders=new HashSet<>();
    public void addOrder(Order order) {
        this.orders.add(order);
        order.setCustomer(this);
    }
    public void removeOrder(Order order) {
        this.orders.remove(order);
//        order.removeCustomer(this);
    }
    public String toString(){
       return "Customer[id"+id+"name"+name+"]";
    }


}
