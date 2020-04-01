package cn.eoneplus.kafkademo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:flamingodev@outlook.com">FLAMINGO</a>
 * @since 2020/3/31 17:39
 */
@Service
public class KafkaService {

    private Logger logger = LoggerFactory.getLogger(KafkaService.class);

    private KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * 注入KafkaTemplate
     *
     * @param kafkaTemplate kafka模版类
     */
    @Autowired
    public KafkaService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = {KafkaTopics.TEST}, groupId = "eoneplus.cn")
    public void listen(ConsumerRecord<Integer, String> record) {
        logger.info("kafka processMessage start");
        logger.info("processMessage, topic = {}, msg = {}", record.topic(), record.value());
        // do something ...
        logger.info("kafka processMessage end");
    }

    @KafkaListener(topics = {KafkaTopics.DEFAULT}, groupId = "eoneplus.cn")
    public void listenDefault(ConsumerRecord<Integer, String> record) {
        logger.info("kafka processMessage start");
        logger.info("processMessage, topic = {}, msg = {}", record.topic(), record.value());
        // do something ...
        logger.info("kafka processMessage end");
    }

    public void send(String topic, String data) {
        kafkaTemplate.send(topic, data);
    }

    public void sendDefaultTopic(String data) {
        kafkaTemplate.send(KafkaTopics.DEFAULT, data);
    }
}
