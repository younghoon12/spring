package com.ch07.entity.board;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"file","comment"})
@Builder
@Entity
@Table(name = "board_article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    private String title;
    private String content;

    /*
        @ManyToOne
        - N : 1 관계 설정
        - Article 엔티티와 User 엔티티간의 관계와 방향성을 고려해서 연관관계 설정
        - Article 엔티티가 조회될 때 User 엔티티도 같이 조회

        @JoinColumn
        - User 엔티티가 참조되는 테이블 컬럼명 설정
        - name 속성은 컬럼명


    */


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer")
    private User user;

    /*
        @OneToMany
          - 1 : N 관계설정, 일반적으로 양방향 관계설정, 참조 타입이 List
          - Article 엔티티와 File 엔티티간의 관계와 방향성을 고려해서 연관관계 설정
          - Article 엔티티가 조회될 때 File 엔티티도 같이 조회
          - mappedBy 속성은 양방향 관계에서 기준이 되는 속성을 설정, FK가 되는 엔티티 속성
          
        @Transactional
          - 양방향으로 처리되는 연관관계에서 다수의 SELECT를 트랜젝션으로 수행
          - 하나의 SELECT는 한번의 세션처리로 트랜젝션 처리하지 않으면 no session 에러 발생
          - 트랜젝션으로 처리하기 위해서 처리 메서드에 @Transactional 선언

        @ToString(exclude="제외할 속성")
          - 엔티티간 양방향 관계설정에서 toString()을 호출할 경우 무한순환 호출이 실행
          - 무한순환 호출이 발생하면 Stackoverflow 에러 발생
          - 양방향으로 관계설정된 엔티티에서 어느 한쪽을 ToString()에서 제외
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
    private List<File> file;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
    private List<Comment> comment;

    @CreationTimestamp
    private LocalDateTime rdate;
}