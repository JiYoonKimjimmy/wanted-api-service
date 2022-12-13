package me.jimmyberg.wanted;

import me.jimmyberg.wanted.config.DatasourceConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest(classes = {DatasourceConfig.class})
class WantedApiServiceApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("Hello Wanted");
    }

    @Test
    void LocalDateTimeTest() {
        String text = "20221213000000";
        LocalDateTime date = LocalDateTime.parse(text, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        System.out.println("date = " + date);
    }

}
