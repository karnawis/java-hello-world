/**
 * File: helloworld/backend/src/main/java/com/example/HelloWorldApplication.java
 * Main Spring Boot application class
 */
package com.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class for the Spring Boot application.
 */
@SpringBootApplication
public class HelloWorldApplication {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
