package org.example;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_in")
    private Calendar dateStart;

    @Column(name = "date_out")
    private Calendar dateFinish;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "service_id")
    private Service service;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "manager_id")
    private Manager manager;

    public Order() {
    }

    public Order(Calendar dateStart, Calendar dateFinish) {
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
    }

    public int getId() {
        return id;
    }

    public Calendar getDateStart() {
        return dateStart;
    }

    public void setDateStart(Calendar dateStart) {
        this.dateStart = dateStart;
    }

    public Calendar getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Calendar dateFinish) {
        this.dateFinish = dateFinish;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy - HH:mm");
        return "Order{" +
                "id=" + id +
                ", dateStart=" + formater.format(dateStart.getTime()) +
                ", dateFinish=" + formater.format(dateFinish.getTime()) +
                '}';
    }
}
