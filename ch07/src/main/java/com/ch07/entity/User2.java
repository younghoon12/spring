package com.ch07.entity;

import com.ch07.dto.User2DTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.Name;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name="user2")
public class User2 {

    @Id
    private String uid;

    @Column(name="name")
    private String name;

    @Column(name="birth")
    private String birth;

    @Column(name="addr")
    private String addr;

    public User2DTO toDTO(){
        return User2DTO.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .addr(addr)
                .build();

    }

}
