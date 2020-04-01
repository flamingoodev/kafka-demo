package cn.eoneplus.kafkademo.common;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * kafka消息封装
 *
 * @author <a href="mailto:flamingodev@outlook.com">FLAMINGO</a>
 * @since 2020/3/31 20:31
 */
@Data
@EqualsAndHashCode
public class Message {
    /**
     * 消息标题
     */
    private String title;
    /**
     * 消息体
     */
    private String body;
}
