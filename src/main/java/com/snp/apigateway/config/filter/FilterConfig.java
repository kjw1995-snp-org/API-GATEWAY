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
                        r -> r.path("/css/**").uri("lb://snp-web/css/")
                )
                .route(
                        r -> r.path("/js/**").uri("lb://snp-web/js/")
                )
                .route(
                        r -> r.path("/img/**").uri("lb://snp-web/img/")
                )
                .route(
                        r -> r.path("/img/**").uri("lb://snp-web/assets/img/")
                )
                .route(
                        r -> r.path("/font/**").uri("lb://snp-web/font/")
                )
                .route(
                        r -> r.path("/fonts/**").uri("lb://snp-web/font/")
                )
                .route(
                        r -> r.path("/data/**").uri("lb://snp-web/data/")
                )
                .route(
                        r -> r.path("/data/**").uri("lb://snp-web/assets/data/")
                )
                .route(
                        r -> r.path("/main/**").uri("lb://snp-web")
                )
                .route(
                        r -> r.path("/login/v1").uri("lb://snp-web/login/v1")
                )
                .route(
                        r -> r.path("/join/**").uri("lb://snp-web/join")
                )
                .route(
                        r -> r.path("/user/login/progress").uri("lb://snp-user-service")
                )
                .route(
                        r -> r.path("/user/join/progress").uri("lb://snp-user-service/user/join/progress")
                )
                .build();
    }

}
