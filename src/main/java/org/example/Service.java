package org.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "price")
    private int servicePrice;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "service")
    private List<Order> orderList = new ArrayList<>();

    public Service() {
    }

    public Service(String serviceName, int servicePrice) {
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
    }

    public int getId() {
        return id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(int servicePrice) {
        this.servicePrice = servicePrice;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", servicePrice=" + servicePrice +
                '}';
    }

    public void addOrder(Order order){
        orderList.add(order);
        order.setService(this);
    }
}
