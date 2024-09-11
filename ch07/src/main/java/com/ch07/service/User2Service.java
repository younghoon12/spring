/* package com.ch07.service;

import com.ch07.dto.User1DTO;
import com.ch07.dto.User2DTO;
import com.ch07.entity.User1;
import com.ch07.entity.User2;
import com.ch07.repository.User2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class User2Service {

    private final User2Repository user2Repository;

    public void insertUser2(User2DTO user2DTO) {

        User2 entity = User2DTO.toEntity();
        user2Repository.save(entity);

    }

    public User2DTO selectUser2(String uid) {

        Optional<User2> opt = user2Repository.findById(uid);

        if(opt.isPresent()){
            // Optional 타입으로 정의된 Entity 가져오기
            User2 user2 = opt.get();

            // Entity를 DTO로 변환해서 반환
            return user2.toDTO();
        }
        return null;

    }

    public List<User2DTO> selectUser2s(){
        List<User2> user2s = user2Repository.findAll();

        List<User2DTO> users = user2s
                .stream()
                .map(entity -> entity.toDTO())
                .collect(Collectors.toList());
        return users;

    }

    public String updateUser2(User2DTO user2DTO){

        boolean result = user2Repository.existsById(user2DTO.getUid());
        if(result){

            User2 entity = user2DTO.toEntity();
            
        }

    }

    public String deleteUser2(){
        return null;
    }


}
*/