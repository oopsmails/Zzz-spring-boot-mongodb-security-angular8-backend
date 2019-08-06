package com.oopsmails.springangularauth;

import com.oopsmails.springangularauth.models.Products;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = { //
        SpringAngularAuthApplication.class, //
        SpringAngularAuthApplicationTests.SpringAngularAuthApplicationTestConfig.class, //
})
public class SpringAngularAuthApplicationTests {
    @Autowired
    protected ObjectMapper objectMapper;


    @Test
    public void contextLoads() throws Exception {
        Products products = new Products();
        products.setProdDesc("Toy abc");
        products.setProdName("Lego Ninja");
        products.setProdPrice(56.66);

        String prettyJsonStr = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(products);
        System.out.println("prettyJsonStr = " + prettyJsonStr);
    }

    @TestConfiguration
//    @ComponentScan("com.oopsmails.springangularauth")
    public static class SpringAngularAuthApplicationTestConfig {
        @Bean
        public Clock appClock() {
            LocalDateTime mockNow = LocalDateTime.of(2019, Month.FEBRUARY, 20, 10, 00, 20);
            Clock result = Clock.fixed(mockNow.atZone(ZoneId.of("Canada/Eastern")).toInstant(), ZoneId.of("Canada/Eastern"));

            return result;
        }
    }
}
