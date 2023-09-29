package com.redhat.demo.kafkacommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Component
public class KafkaProducer {
    @Autowired
    private final KafkaTemplate<String, String> kafkaTemplate;

    // public void sendMessage(String message) {
    //     CompletableFuture<SendResult<String, String>> future = (CompletableFuture<SendResult<String, String>>) kafkaTemplate.send("streams-plaintext-input", message);
    //     future.whenComplete((result, ex) -> {
    //         if (ex == null) {
    //             log.info("Message sent to topic: {}", message);
    //      } else {
    //          log.error("Failed to send message", ex);
    //      }
    //  });
    // }

    public void sendMessage(String msg) {
        String[] keyValue = msg.split(":");
        String key = keyValue[0];
        String value = keyValue[1];
        System.out.println("Key : " + key + ", Value : "+value);
        kafkaTemplate.send("streams-plaintext-input", key, value);
    }
}
