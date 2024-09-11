package com.ch07.dto;

import com.ch07.entity.User2;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User2DTO {
    private String uid;
    private String name;
    private String birth;
    private String addr;

    public User2 toEntity(){

        return User2.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .addr(addr)
                .build();

    }
}
