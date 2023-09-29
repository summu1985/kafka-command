package com.redhat.demo.kafkacommand;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WordCountRestService {
    //private final StreamsBuilderFactoryBean factoryBean;
    private final KafkaProducer kafkaProducer;

    @PostMapping("/message")
    public void addMessage(@RequestBody String message) {
        kafkaProducer.sendMessage(message);
    }
}
