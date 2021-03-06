package me.flyray.message.rocketmq.service;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * 消息接口
 */
public interface RocketMqMessageListener {
    boolean onMessage(List<MessageExt> messages,
                      ConsumeConcurrentlyContext Context);
}
