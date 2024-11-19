<<<<<<< HEAD
package top.xg.springboot.configure.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ServerTest {
  @Resource
    private Server server;

  @Test
    void test() {
      System.out.println(server);
  }
=======
package top.xg.springboot.configure.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ServerTest {
  @Resource
    private Server server;

  @Test
    void test() {
      System.out.println(server);
  }
>>>>>>> 3a445c108c2cb986de68ce29000d3e6bf4ca24b3
}