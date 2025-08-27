package com.example.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // Аннотация применима к методам
@Retention(RetentionPolicy.RUNTIME) // Аннотация доступна в runtime
public @interface LogExecution {
}