package com.ch07.repository.shop;

import com.ch07.entity.board.User;
import com.ch07.entity.shop.Customer;
import com.ch07.entity.shop.Order;
import com.ch07.entity.shop.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShopRepositoryTest {

    @Autowired private CustomerRepository customerRepository;
    @Autowired private ProductRepository productRepository;
    @Autowired private OrderRepository orderRepository;
    @Autowired private OrderItemRepository orderItemRepository;

    // 테스트1 - 사용자 등록
    @Test
    void insertCustomerTest(){
        Customer customer1 = Customer.builder()
                .custId("a101")
                .name("김유신")
                .hp("010-1234-5678")
                .addr("부산광역시")
                .age(23)
                .build();
        Customer customer2 = Customer.builder()
                .custId("a102")
                .name("김춘추")
                .hp("010-1234-1111")
                .addr("광주광역시")
                .age(34)
                .build();
        Customer customer3 = Customer.builder()
                .custId("a103")
                .name("이순신")
                .hp("010-1234-2222")
                .addr("경남 통영시")
                .age(45)
                .build();

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
    }

    @Test
    void insertProductTest(){
        Product product1 = Product.builder()
                .productId(1)
                .productName("농심새우깡")
                .price(1000)
                .stock(100)
                .build();

        Product product2 = Product.builder()
                .productId(2)
                .productName("감자칩")
                .price(2000)
                .stock(200)
                .build();

        productRepository.save(product1);
        productRepository.save(product2);
    }

    void insertOrderTest(){

        Customer customer = Customer.builder()
                .custId("a101")
                .build();

        Product product1 = Product.builder().productId(1).build();
        Product product2 = Product.builder().productId(2).build();

        Order order = Order.builder()
                .customer(customer)
                .orderPrice(3000)
                .build();

    }
}
