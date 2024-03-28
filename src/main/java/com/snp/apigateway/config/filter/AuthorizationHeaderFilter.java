package com.snp.apigateway.config.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;


@Component
@Slf4j
public class AuthorizationHeaderFilter extends AbstractGatewayFilterFactory<AuthorizationHeaderFilter.Config> {

    @Value("{jwt.secret-key}")
    private String secretKey;

    @Override
    public GatewayFilter apply(AuthorizationHeaderFilter.Config config) {

        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();

            log.info("Request Headers = {}", request.getHeaders());

            return chain.filter(exchange);
        };
    }

    public static class Config {

        private String auth = "USER";

        public String getAuth() {
            return this.auth;
        }

    }

}
