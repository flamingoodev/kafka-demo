package cn.eoneplus.kafkademo.consumer;


import cn.eoneplus.kafkademo.common.KafkaTopics;
import cn.eoneplus.kafkademo.common.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 *
 * @author <a href="mailto:flamingodev@outlook.com">FLAMINGO</a>
 * @since 2020/3/31 20:31
 */
@Component
public class Consumer {

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = KafkaTopics.DEFAULT)
    public void listenDefault(Message message) {
        logger.info(message.toString());
    }

    @KafkaListener(topics = KafkaTopics.TEST)
    public void listenTest(Message message) {
        logger.info(message.toString());
    }
}