package com.university.elasticsearchconnector.service;

public interface ElasticPublisherService<T> {

    void saveDoc(T document, String index);

}
