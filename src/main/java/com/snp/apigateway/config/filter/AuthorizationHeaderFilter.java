package com.snp.apigateway.config.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuthorizationHeaderFilter extends AbstractGatewayFilterFactory<AuthorizationHeaderFilter.Config> {

    @Value("{jwt.secret-key}")
    private String secretKey;

    @Override
    public GatewayFilter apply(AuthorizationHeaderFilter.Config config) {

        return (exchange, chain) -> {

            String requireAuth = config.getAuth();

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
