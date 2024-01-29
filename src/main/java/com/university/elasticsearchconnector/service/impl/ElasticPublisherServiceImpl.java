package com.university.elasticsearchconnector.service.impl;

import com.university.elasticsearchconnector.service.ElasticPublisherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.client.elc.ReactiveElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ElasticPublisherServiceImpl implements ElasticPublisherService<Document> {

    private final ReactiveElasticsearchTemplate reactiveElasticsearchTemplate;

    @Override
    public void saveDoc(Document document, String index) {
        reactiveElasticsearchTemplate.save(document, IndexCoordinates.of(index))
                .doOnError(error -> log.error("Error occurred while saving document into index: {}", index, error))
                .subscribe(result -> log.info("Doc: {} saved into index: {}", result, index));

    }
}
