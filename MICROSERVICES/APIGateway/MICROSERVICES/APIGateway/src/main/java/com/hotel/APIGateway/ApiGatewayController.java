package com.hotel.APIGateway;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
public class ApiGatewayController {

	@RequestMapping("/Head")
	public Mono<String> masterServiceFallBack() {
		return Mono.just(" Service Head taking too long");
	}
	@RequestMapping("/Booking")
	public Mono<String> bookingServiceFallBack() {
		return Mono.just(" Service booking taking too long");
	}
	@RequestMapping("/Security")
	public Mono<String> authServiceFallBack() {
		return Mono.just(" Service Security taking too long");
	}
}
