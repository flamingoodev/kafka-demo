package cn.eoneplus.kafkademo.controller;


import cn.eoneplus.kafkademo.common.KafkaTopics;
import cn.eoneplus.kafkademo.common.Message;
import cn.eoneplus.kafkademo.common.Result;
import cn.eoneplus.kafkademo.producer.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:flamingodev@outlook.com">FLAMINGO</a>
 * @since 2020/3/31 20:31
 */
@RestController
@RequestMapping("/kafka")
public class ProduceController {

    @Autowired
    private KafkaService kafkaService;

    @RequestMapping(value = "/send", method = RequestMethod.POST, produces = {"application/json"})
    public Result send(@RequestBody Message message) {
        kafkaService.send(KafkaTopics.TEST, message);
        kafkaService.send(message);
        return Result.ok().put("kafka", "消息发送成功");
    }

}