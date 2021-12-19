package com.my_company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringLoopStarter {
    public static void main(String[] args) {

        SpringApplication.run(SpringLoopStarter.class,args);

    }
}
