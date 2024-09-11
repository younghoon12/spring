package com.ch07.repository.shop;



// CustomerRepository 확장 인터페이스 구현 클래스

import com.ch07.entity.shop.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void selectCustomers() {
        List<Customer> customers = customerRepository.selectCustomers();
        System.out.println(customers);
    }

    @Test
    public void selectProjectionCustomer(){
        Customer customer = customerRepository.selectCustomer("a102");
        System.out.println(customer);
    }

    //@Test
    public void selectCustomer() {
        Customer customer = customerRepository.selectCustomer("a101");
        System.out.println(customer);

    }
    @Test
    public void searchCustomer() {

        List<Customer> customer1 =customerRepository.searchCustomer("김유신", 23);
        List<Customer> customer2 =customerRepository.searchCustomer("김유신", 0);
        List<Customer> customer3 =customerRepository.searchCustomer(null, 23);
        List<Customer> customer4 =customerRepository.searchCustomer(null, 0);

    }
    @Test
    public void searchKeyword(){

        List<Customer> customers1 = customerRepository.searchKeyword("유신");
        List<Customer> customers2 = customerRepository.searchKeyword("통영");

        System.out.println(customers1);
        System.out.println(customers2);

    }






}
