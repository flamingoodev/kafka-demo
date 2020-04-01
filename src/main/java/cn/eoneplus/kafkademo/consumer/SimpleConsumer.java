package cn.eoneplus.kafkademo.consumer;


import cn.eoneplus.kafkademo.common.KafkaTopics;
import cn.eoneplus.kafkademo.common.Message;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Component;

/**
 * 简单消费者
 *
 * @author <a href="mailto:flamingodev@outlook.com">FLAMINGO</a>
 * @since 2020/3/31 20:31
 */
@Component
public class SimpleConsumer {

    private static final Logger logger = LoggerFactory.getLogger(SimpleConsumer.class);

    @KafkaListener(topics = KafkaTopics.DEFAULT)
    public void listenDefault(Message message) {
        System.out.println(JsonDeserializer.class);
        System.out.println(StringDeserializer.class);
        System.out.println(StringSerializer.class);
        System.out.println(JsonSerializer.class);

        logger.error(message.toString());
    }
    @KafkaListener(topics = KafkaTopics.TEST)
    public void listenTest(Message message) {
        logger.error(message.toString());
    }
}