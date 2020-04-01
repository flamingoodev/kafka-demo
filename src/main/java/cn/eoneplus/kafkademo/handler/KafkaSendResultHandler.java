package cn.eoneplus.kafkademo.handler;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:flamingodev@outlook.com">FLAMINGO</a>
 * @since 2020/3/31 20:31
 */

@Component
public class KafkaSendResultHandler implements ProducerListener {

    private static final Logger logger = LoggerFactory.getLogger(KafkaSendResultHandler.class);

    @Override
    public void onSuccess(ProducerRecord producerRecord, RecordMetadata recordMetadata) {
        logger.info("Message send success : " + producerRecord.toString());
    }

    @Override
    public void onError(ProducerRecord producerRecord, Exception exception) {
        logger.warn("Message send error : " + producerRecord.toString());
    }
}
