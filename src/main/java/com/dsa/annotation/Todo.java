package com.dsa.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Todo {
    enum Priority{LOW, MEDIUM, HIGH}
    enum Status {STARTED, NOT_STARTED}
    String author() default "Burusoth";
    Priority priority() default Priority.LOW;
    Status status() default Status.NOT_STARTED;
}
