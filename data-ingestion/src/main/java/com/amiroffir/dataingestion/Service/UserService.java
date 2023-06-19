package com.amiroffir.dataingestion.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private KafkaTemplate<String, byte[]> kafkaTemplate;

    public void publishMessageToKafka(ProtoUser protoUser) {
        byte[] serializedUser = protoUser.toByteArray();
        kafkaTemplate.send("data-ingestion-topic", serializedUser);
    }

}