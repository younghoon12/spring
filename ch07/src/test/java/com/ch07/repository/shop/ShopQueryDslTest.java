package com.ch07.repository.shop;

import com.ch07.dto.CustomerDTO;
import com.ch07.dto.ProductAggDTO;
import com.ch07.entity.shop.*;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ShopQueryDslTest {

    /*
    QueryDSL 설정
        1) 의존성
         - build.gradle 의존성 추가
         - build.gradle 파일 QueryDSL 경로 및 환경설정
         - Q도메인 클래스 생성 확인(애플리케이션 실행상태 확인)

        2) QueryDSL 구현
            - 개별 Repository 확장 Custom 인터페이스 생성
            - Custom 인터페이스 구현하는 Impl 클래스 생성
            - Impl 클래스에서 QueryDSL 쿼리메서드 정의
            - 개별 Repository에 Custom 인터페시으 상속 추가

     */

    @Autowired
    private JPAQueryFactory queryFactory;

    private QCustomer qCustomer = QCustomer.customer;
    private QProduct qProduct = QProduct.product;
    private QOrder qOrder = QOrder.order;
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    void test01(){
        List<Customer> customers = jpaQueryFactory
                                  .selectFrom(qCustomer)
                                  .fetch();
    }
    @Test
    void test02(){
        List<Product> products = jpaQueryFactory
                .select(
                        Projections.fields(
                                Product.class,
                                qProduct.productId,
                                qProduct.productName,
                                qProduct.price
                        )

                )
                .from(qCustomer)
                .fetch(); // fetch 결과는 List
        System.out.println(products);
    }
    @Test
    void test03(){
        List<Customer> customers1 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.name.eq("김유신")).fetch();
        List<Customer> customers2 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.name.ne("김유신")).fetch();

        System.out.println(customers1);
        System.out.println(customers2);
    }
    @Test
    void test04(){
        List<Customer> customers1 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.gt(30)).fetch();
        List<Customer> customers2 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.goe(30)).fetch();
        List<Customer> customers3 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.lt(30)).fetch();
        List<Customer> customers4 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.loe(30)).fetch();
    }
    @Test
    void test05(){
        List<Customer> customers = jpaQueryFactory
                                        .selectFrom(qCustomer)
                                        .where(qCustomer.addr.in("서울", "김해"))
                                        .fetch();
        System.out.println(customers);
    }
    @Test
    void test06(){
        List<Customer> customers = jpaQueryFactory
                .selectFrom(qCustomer)
                .where(qCustomer.name.like("%신"))
                .fetch();
        System.out.println(customers);
    }
    @Test
    void test07(){
        List<Product> products = jpaQueryFactory
                .selectFrom(qProduct)
                .where(qProduct.stock.gt(0))
                .orderBy(qProduct.price.desc())
                .fetch();
    }
    @Test
    void test08(){
        List<Product> products = jpaQueryFactory
                .selectFrom(qProduct)
                .where(qProduct.stock.gt(0))
                .orderBy(qProduct.price.asc())
                .offset(0)
                .limit(3)
                .fetch();
        System.out.println(products);
    }
    @Test
    void test09(){
        ProductAggDTO productAggDTO  = jpaQueryFactory
                .select(
                        Projections.fields(
                                ProductAggDTO.class,
                                qProduct.price.sum().as("priceSum"),
                                qProduct.price.avg().as("priceAvg"),
                                qProduct.price.max().as("priceMax"),
                                qProduct.price.min().as("priceMin")
                        )
                ).from(qProduct)
                .fetchOne();
        System.out.println(productAggDTO);

    }
    @Test
    void test10(){

        List<CustomerDTO> customerDTOS = jpaQueryFactory
                                            .select(
                                                    Projections.fields(
                                                    CustomerDTO.class,
                                                    qOrder.customer.custId,
                                                    qOrder.customer.name,
                                                    qOrder.customer.custId.count().as("orderCount")
                                                    )
                                            )
                                            .from(qOrder)
                                            .where(qOrder.orderStatus.eq())
                                            .groupBy(qOrder.customer.custId)
                                            .having(qOrder.customer.custId.count().goe(2))
                                            .fetch();
    }
    @Test
    void test11(){
        List<Tuple> result = jpaQueryFactory
                .select(qOrder, qCustomer)
                .from(qOrder)
                .join(qCustomer)
                .on(qOrder.customer.eq(qCustomer))
                .fetch();
        System.out.println(result);
    }
    @Test
    void test12(){
    }
    @Test
    void test13(){
    }



}
