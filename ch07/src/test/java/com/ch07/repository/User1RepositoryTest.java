package com.ch07.repository;

import com.ch07.entity.User1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class User1RepositoryTest {

    @Autowired
    private User1Repository user1Repository;

    @Test
    void findUser1ByUid() {
        User1 entity = user1Repository.findUser1ByUid("a101");

        System.out.println(entity);

    }

    @Test
    void findUser1ByName() {
        List<User1> users = user1Repository.findUser1ByName("홍길동");

        System.out.println(users);
    }

    @Test
    void findUser1ByNameNot() {
        List<User1> users = user1Repository.findUser1ByNameNot("홍길동");

        System.out.println(users);
    }

    @Test
    void findUser1EntityByUidAndName() {
        List<User1> entity = user1Repository.findUser1EntityByUidAndName("a22", "홍길동");
        System.out.println(entity);
    }

    @Test
    void findUser1ByAgeGreaterThan() {
    }

    @Test
    void findUser1ByAgeGreaterThanEqual() {
    }

    @Test
    void findUser1ByAgeLessThan() {
    }

    @Test
    void findUser1ByAgeLessThanEqual() {
    }

    @Test
    void findUser1ByAgeBetween() {
    }

    @Test
    void selectUser1UnderAge30() {
    }

    @Test
    void selectUser1whereName() {
    }

    @Test
    void selectUser1whereNameParam() {
    }

    @Test
    void selectFromParentJoinChild() {
        List<Object[]> list = user1Repository.selectFromParentJoinChild("P101");
        System.out.println(list);

        }
    }
