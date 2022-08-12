package com.dd.api.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;

@Slf4j
public class ElasticSearchConnectionUtils {

    static RestHighLevelClient restHighLevelClient;

    @Bean("client")
    public static RestHighLevelClient create(String host, int port) {
        try {
            if (restHighLevelClient == null) {
                restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost(host, port, "http")));
            }
        } catch (Exception e) {
            log.info("ElasticSearchConnectionUtils ERROR : ", e);
        }
        return restHighLevelClient;
    }

    public static void close(){
        try {
            if (restHighLevelClient != null) {
                restHighLevelClient.close();
            }
        } catch (Exception e) {
            log.error("ElasticSearchConnectionUtils ERROR : ", e);
        }
    }
}
