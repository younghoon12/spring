package com.ch07.repository.shop.impl;


import com.ch07.entity.shop.Order;
import com.ch07.entity.shop.QCustomer;
import com.ch07.entity.shop.QOrder;
import com.ch07.repository.shop.custom.OrderRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;

public class OrderRepositoryinpl implements OrderRepositoryCustom {


    @Override
    public List<Order> selectOrders() {
        return List.of();
    }

    @Override
    public List<Order> selectOrders(int OrderId) {
        return List.of();
    }
}
