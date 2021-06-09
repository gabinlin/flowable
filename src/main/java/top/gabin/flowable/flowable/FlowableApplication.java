package top.gabin.flowable.flowable;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlowableApplication {

    @Bean
    SpringUtil springUtil() {
        return new SpringUtil();
    }

    public static void main(String[] args) {
        SpringApplication.run(FlowableApplication.class, args);
    }

}
