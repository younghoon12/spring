package com.ch03.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.ch03"})
@EnableAspectJAutoProxy /** 이걸 써야지만 AOP */
public class Appconfig {

}
