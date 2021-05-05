package io.github.ust.mico.readandforward;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Sender {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  @Value("${kafka.output-topic}")
  private String topic;

  public void send(String message) {
    log.info("sending msg:'{}' to topic:'{}'", message, topic);
    kafkaTemplate.send(topic, message);
  }
}
