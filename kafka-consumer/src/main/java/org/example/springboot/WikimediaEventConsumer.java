package org.example.springboot;

import org.example.springboot.entity.WikimediaData;
import org.example.springboot.repository.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WikimediaEventConsumer {
    private Logger logger = LoggerFactory.getLogger(WikimediaEventConsumer.class);
    private final WikimediaRepository wikimediaRepository;

    public WikimediaEventConsumer(WikimediaRepository wikimediaRepository) {
        this.wikimediaRepository = wikimediaRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void EventConsumer(String message) {
        logger.info("Received Message: {}", message);
        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(message);
        wikimediaRepository.save(wikimediaData);
    }
}
