package org.example.finalorder_customers;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long id;
    @ManyToOne
    @JoinTable(name = "cust_id")
    private Customer customer;
    public void addCustomer(Customer customer) {
        this.customer=customer;
        customer.getOrders().add(this);
    }
    public void removeCustomer(Customer customer) {
        this.customer=null;
        customer.getOrders().remove(this);
    }
    public String toString() {
        return "Order[id"+id;
    }

}
