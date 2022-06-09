package com.spring.sue.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 어노테이션 사용 위치 > 메서드의 파라미터
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}
