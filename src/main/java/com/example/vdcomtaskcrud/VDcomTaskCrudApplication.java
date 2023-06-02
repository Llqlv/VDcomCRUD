package com.example.vdcomtaskcrud;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VDcomTaskCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(VDcomTaskCrudApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}