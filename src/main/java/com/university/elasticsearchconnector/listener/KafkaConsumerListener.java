package com.university.elasticsearchconnector.listener;


import com.university.elasticsearchconnector.service.impl.ElasticPublisherServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumerListener {

    private final ElasticPublisherServiceImpl elasticPublisherService;

    /**
     * This method listens to the topic that was configured in the application.yml file and responsible for send it to elasticSearch
     *
     * @param rowChanges changes took from debezium topic name
     */
    @KafkaListener(groupId = "${spring.kafka.groups.events-data-group-id}", topics = {"${spring.kafka.topic-name.changes-data}"})
    public void listen(String rowChanges, @Header(KafkaHeaders.RECEIVED_TOPIC) String indexTopicName) {
        log.info("Receive message from Kafka{} and topic {}", rowChanges, indexTopicName);
        var mapDocument = Document.parse(rowChanges);
        elasticPublisherService.saveDoc(mapDocument, indexTopicName);
    }
}
