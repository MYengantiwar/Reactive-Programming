package com.reactive.ReactiveProject.controller;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/reactive")
public class ReactiveController {

	@GetMapping("/checkflux")
	public void checkflux() {
		
		System.out.println("Testing checkflux ");
		/*Flux.interval(Duration.ofMillis(10)).subscribe( i -> {
			System.out.println("value of i="+i);
		});*/
	}
}
