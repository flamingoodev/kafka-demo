package cn.eoneplus.kafkademo.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author <a href="mailto:flamingodev@outlook.com">FLAMINGO</a>
 * @since 2020/3/31 21:34
 */
@Component
public class KafkaProducerInterceptor implements ProducerInterceptor<String, String> {
    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> producerRecord) {
        // TODO Auto-generated method stub
        // 可以在此方法中定义对消息做一些特殊处理
        return producerRecord;
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {
        // TODO Auto-generated method stub
        // 该方法会在消息被应答之前或消息发送失败的时候调用，也可以在此做重试操作
        recordMetadata.partition();
        recordMetadata.topic();
        recordMetadata.serializedKeySize();
        recordMetadata.serializedValueSize();
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
