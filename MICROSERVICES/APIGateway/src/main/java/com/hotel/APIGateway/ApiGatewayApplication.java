package com.hotel.APIGateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
public class ApiGatewayApplication {

	 @RequestMapping("/Head")
	    public Mono<String> masterServiceFallBack() {
	        return Mono.just(" Service master is responding too long");
	    }
	    @RequestMapping("/Booking")
	    public Mono<String> bookingServiceFallBack() {
	        return Mono.just(" Service booking is responding too long");
	    }
	    @RequestMapping("/Auth")
	    public Mono<String> authServiceFallBack() {
	        return Mono.just(" Service auth is responding too long");
	    }
}
