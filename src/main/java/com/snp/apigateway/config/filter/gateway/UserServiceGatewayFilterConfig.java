package com.snp.apigateway.config.filter.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceGatewayFilterConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder routeBuilder) {
        return routeBuilder.routes()
                .route(
                        r -> r.path("/user/login/progress").uri("lb://snp-user-service")
                )
                .build();
    }

}
