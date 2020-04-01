package cn.eoneplus.kafkademo;

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

    @Test
    void sendDefaultTopic() {
        kafkaService.sendDefaultTopic("This is default topic!");
    }

    @Test
    void send() {
        kafkaService.send(KafkaTopics.TEST, "This is test topic!");
    }

}
