package me.jimmyberg.wanted;

import me.jimmyberg.wanted.config.DatasourceConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {DatasourceConfig.class})
class WantedApiServiceApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("Hello Wanted");
    }

}
