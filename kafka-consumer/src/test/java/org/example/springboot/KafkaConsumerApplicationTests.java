package org.example.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class KafkaConsumerApplicationTests {

    @Autowired
    private WikimediaEventConsumer wikimediaEventConsumer;

    @Test
    void dependencyTest() {
        assertNotNull(wikimediaEventConsumer);
    }

}
