<<<<<<< HEAD
package top.xg.springboot.configure.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PersonTest {
 @Resource
    private Person person;

 @Test
    void testPerson() {
     System.out.println(person);
 }
=======
package top.xg.springboot.configure.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PersonTest {
 @Resource
    private Person person;

 @Test
    void testPerson() {
     System.out.println(person);
 }
>>>>>>> 3a445c108c2cb986de68ce29000d3e6bf4ca24b3
}