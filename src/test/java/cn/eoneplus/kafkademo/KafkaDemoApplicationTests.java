package cn.eoneplus.kafkademo;

import cn.eoneplus.kafkademo.producer.KafkaService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class KafkaDemoApplicationTests {
    @Resource
    private KafkaService kafkaService;

    @Test
    void contextLoads() {
    }
}
