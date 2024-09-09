package com.ch06.dao;

import com.ch06.dto.User1DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface User1Mapper {
    public void insertUser1(User1DTO user1DTO);
    public User1DTO selectUser1(String uid);
    public List<User1DTO> selectUser1s();
    public void updateUser1(User1DTO user1DTO);
    public void deleteUser1(String uid);
}