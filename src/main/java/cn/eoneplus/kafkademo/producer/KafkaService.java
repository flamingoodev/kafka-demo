package cn.eoneplus.kafkademo.producer;

import cn.eoneplus.kafkademo.common.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:flamingodev@outlook.com">FLAMINGO</a>
 * @since 2020/3/31 17:39
 */
@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    /**
     * 发送默认topic的信息
     *
     * @param message 封装后的消息
     */
    public void send(Message message) {
        kafkaTemplate.sendDefault(message);
    }


    /**
     * 发送消息
     *
     * @param topic   消息主题
     * @param message 封装后的消息
     */
    public void send(String topic, Message message) {
        kafkaTemplate.send(topic, message);
    }
}
