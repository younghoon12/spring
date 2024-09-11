package com.ch07.entity.shop;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCustomer is a Querydsl query type for Customer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCustomer extends EntityPathBase<Customer> {

    private static final long serialVersionUID = 1661233792L;

    public static final QCustomer customer = new QCustomer("customer");

    public final StringPath addr = createString("addr");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath custId = createString("custId");

    public final StringPath hp = createString("hp");

    public final StringPath name = createString("name");

    public final StringPath regDate = createString("regDate");

    public QCustomer(String variable) {
        super(Customer.class, forVariable(variable));
    }

    public QCustomer(Path<? extends Customer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCustomer(PathMetadata metadata) {
        super(Customer.class, metadata);
    }

}

