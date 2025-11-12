package com.scheduleappdevelop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // @EntityListeners, @CreatedDate, @LastModifiedDate들은 @EnableJpaAuditing이 있어야 실제 작동함
@SpringBootApplication
public class ScheduleAppDevelopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleAppDevelopApplication.class, args);
    }

}
