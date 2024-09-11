package com.ch07.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity                  // 엔티티 객체 정의
@Table(name="parent")     // 매핑 테이블 설정 어노테이션
public class Parent {

    @Id
    private String pid;
    private String name;
    private String birth;
    private String addr;
}
