package com.soft1721.jianyue;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.soft1721.jianyue.mapper")
@EnableSwagger2Doc
public class JianyueApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(JianyueApiApplication.class, args);
    }
}
