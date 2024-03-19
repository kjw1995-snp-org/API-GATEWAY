package com.snp.apigateway.config.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


@Component
@Slf4j
public class GlobalFilter extends AbstractGatewayFilterFactory<GlobalFilter.Config> {

    @Data
    public static class Config {
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;
    }

    @Override
    public GatewayFilter apply(Config config) {

        return ((exchange, chain) -> {
                ServerHttpRequest request = exchange.getRequest();
                ServerHttpResponse response = exchange.getResponse();

                log.info("GlobalFilter BaseMessage = {}", config.getBaseMessage());

                if(config.isPreLogger()) {
                    log.info("request Uri = {}", request.getURI());
                }

                return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                    if(config.isPostLogger()) {
                        log.info("response code = {}", response.getStatusCode());
                    }
                }));

            }

        );

    }




}
