package com.dummy.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping
public class CreatePerson {
    @RequestMapping(value="/create_person_method", method = RequestMethod.POST)
    public ResponseEntity<String> method(@RequestBody PatternJSON requestObject) throws IOException{
        send(requestObject);

        return ResponseEntity.status(200).body("Message received successfully");
    }

    @Autowired
    public KafkaTemplate<String, PatternJSON> kafkaTemplate;

    public void send(PatternJSON pt){
        kafkaTemplate.send("123", pt);
    }
}
