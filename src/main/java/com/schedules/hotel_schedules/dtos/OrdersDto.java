package com.schedules.hotel_schedules.dtos;

public class OrdersDto {
    private long id;
    private Integer OrderNumber;
    private float price;
    private Integer quantity;
    private int fkIdInventory;
    private int fkIdSchedule;

    public OrdersDto() {
    }

    public OrdersDto(long id, Integer orderNumber, float price, Integer quantity, int fkIdInventory, int fkIdSchedule) {
        this.id = id;
        OrderNumber = orderNumber;
        this.price = price;
        this.quantity = quantity;
        this.fkIdInventory = fkIdInventory;
        this.fkIdSchedule = fkIdSchedule;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        OrderNumber = orderNumber;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public int getFkIdInventory() {
        return fkIdInventory;
    }

    public void setFkIdInventory(int fkIdInventory) {
        this.fkIdInventory = fkIdInventory;
    }

    public int getFkIdSchedule() {
        return fkIdSchedule;
    }

    public void setFkIdSchedule(int fkIdSchedule) {
        this.fkIdSchedule = fkIdSchedule;
    }

    @Override
    public String toString() {
        return "OrdersDto [id=" + id + ", OrderNumber=" + OrderNumber + ", price=" + price + ", quantity=" + quantity
                + ", fkIdInventory=" + fkIdInventory + ", fkIdSchedule=" + fkIdSchedule + "]";
    }

}
