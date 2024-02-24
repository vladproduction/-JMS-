package com.vladproduction.ecommerceplatform.model;

import java.util.Date;
import java.util.Objects;

public class Order {

    private String name;
    private String description;
    private Date produceDate;
    private double price;

    public Order(String name, String description, Date produceDate, double price) {
        this.name = name;
        this.description = description;
        this.produceDate = produceDate;
        this.price = price;
    }

    public Order() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(Date produceDate) {
        this.produceDate = produceDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(price, order.price) == 0 && Objects.equals(name, order.name) && Objects.equals(description, order.description) && Objects.equals(produceDate, order.produceDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, produceDate, price);
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", produceDate=" + produceDate +
                ", price=" + price +
                '}';
    }
}
