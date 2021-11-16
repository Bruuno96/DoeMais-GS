package com.murilonerdx.doemais;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.murilonerdx.doemais.entities.Business;
import com.murilonerdx.doemais.repository.BusinessRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableJpaRepositories
@EnableScheduling
public class DoeMaisApplication {

    @Autowired
    private BusinessRepository businessRepository;

    @Scheduled(cron = "0 0 0 1 1/1 *")
    public void agendamentoOrder() {
        List<Business> business = businessRepository.findAll();
        Set<Business> businessUpdate = business.stream().peek(x->{
            x.setTribute(0.00);
            x.setPoints(0.00);
        }).collect(Collectors.toSet());
        System.out.println(businessRepository.saveAll(businessUpdate));
    }

    public static void main(String[] args) {
        SpringApplication.run(DoeMaisApplication.class, args);
    }

}
