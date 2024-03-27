package com.snp.apigateway.config.filter;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig { // SNP-WEB Server Gateway Config

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder routeBuilder) {

        return routeBuilder.routes()
                .route(
                        r -> r.path("/docs/**").uri("lb://web/docs/")
                )
                .route(
                        r -> r.path("/favicon.ico").uri("lb://web/img/")
                )
                .route(
                        r -> r.path("/css/**").uri("lb://web/css/")
                )
                .route(
                        r -> r.path("/js/**").uri("lb://web/js/")
                )
                .route(
                        r -> r.path("/img/**").uri("lb://web/img/")
                )
                .route(
                        r -> r.path("/img/**").uri("lb://web/assets/img/")
                )
                .route(
                        r -> r.path("/font/**").uri("lb://web/font/")
                )
                .route(
                        r -> r.path("/fonts/**").uri("lb://web/font/")
                )
                .route(
                        r -> r.path("/data/**").uri("lb://web/data/")
                )
                .route(
                        r -> r.path("/data/**").uri("lb://web/assets/data/")
                )
                .route(
                        r -> r.path("/main/**").uri("lb://web")
                )
                .route(
                        r -> r.path("/login/v1").uri("lb://web/login/v1")
                )
                .route(
                        r -> r.path("/login/v2").uri("lb://web/login/v2")
                )
                .route(
                        r -> r.path("/join/**").uri("lb://web/join")
                )
                .route(
                        r -> r.path("/join/progress").uri("lb://web/join/progress")
                )
                .route(
                        r -> r.path("/login/action").uri("lb://web/login/action")
                )
                .route(
                        r -> r.path("/user/login/action").uri("lb://user-service/user/login/action")
                )
                .route(
                        r -> r.path("/user/join/progress").uri("lb://user-service/user/join/progress")
                )
                .build();
    }

}
