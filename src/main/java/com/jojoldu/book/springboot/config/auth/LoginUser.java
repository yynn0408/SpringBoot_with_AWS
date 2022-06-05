package com.jojoldu.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 어노테이션을 파라미터로 생성
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser { // LoginUser 어노테이션 클래스로 생성
}
