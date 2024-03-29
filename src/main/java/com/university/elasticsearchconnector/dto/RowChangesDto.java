package com.university.elasticsearchconnector.dto;

import io.debezium.data.Envelope;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RowChangesDto implements Serializable {

    private String tableNameId;

    private Envelope.Operation operation;

    private Map<String, Object> data;

}
