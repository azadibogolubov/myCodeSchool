package com.azadibogolubov.aftercodeschool.annotations;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.GET, produces = "application/json")
public @interface JsonGetMapping {
    @AliasFor(annotation = RequestMapping.class, attribute = "produces")
    String[] produces() default {"application/json"};

    @AliasFor(annotation = RequestMapping.class, attribute = "value")
    String[] value() default {};
}