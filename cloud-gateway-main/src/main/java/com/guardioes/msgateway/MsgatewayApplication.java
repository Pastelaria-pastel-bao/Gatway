package com.guardioes.msgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class MsgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsgatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder
				.routes()
					.route(r -> r.path("/api/v1/pasteis/**").uri("lb://cadastramento"))
					.route(r -> r.path("/api/v1/usuarios/**").uri("lb://cadastrousuarios"))
					.route(r -> r.path("/item/**").uri("lb://pedidos"))
				    .route(r -> r.path("/pedidos/**").uri("lb://pedidos"))
					.route(r -> r.path("/api/v1/email/**").uri("lb://servicoemail"))
				.build();
	}

}
