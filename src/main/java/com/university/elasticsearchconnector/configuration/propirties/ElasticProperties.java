package com.university.elasticsearchconnector.configuration.propirties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "spring.elasticsearch")
public class ElasticProperties {

    private String host;

    private Integer port;

    private String password;

    private String username;

    private String scheme;

    private Integer socketTimeout;

    private Integer connectionTimeout;

    private String certPath;

    private String certPassword;

}
