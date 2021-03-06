package com.herojoon.jpaproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@SuperBuilder
@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  // JPA에서 lazy관련 에러 날 경우 사용
@Entity  // 객체와 테이블 매핑
@Table(name = "MEMBER")  // index 없음 (기본 테이블 생성)
//@Table(name = "MEMBER", indexes = @Index(name = "idx__email__birthday", columnList = "email, birthday"))  // 단일 index 생성
/*@Table(name = "MEMBER", indexes = {  // 복합 index 생성
        @Index(name = "idx__email__birthday", columnList = "email, birthday"),  // index (unique = false (default))
        @Index(name = "idx__name__age", columnList = "name, age"),  // index (unique = false (default))
        @Index(name = "idx__unique__nickname", columnList = "nickname", unique = true)  // unique index
})*/
public class Member {
    @Id  // Primary Key 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // AUTO_INCREMENT 설정 (id값이 null일 경우 자동 생성)
    @Column(name = "ID")  // 컬럼 지정
    private Long id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "email")
    private String email;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "BIRTHDAY")
    private Date birthday;
}
