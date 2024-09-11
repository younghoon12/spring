package com.ch07.repository.shop.custom;

import com.ch07.entity.shop.Order;

import java.util.List;

public interface OrderRepositoryCustom {

    public List<Order> selectOrders();
    public List<Order> selectOrders(int OrderId);

    //public List<Order> searchOrders(String );
}
