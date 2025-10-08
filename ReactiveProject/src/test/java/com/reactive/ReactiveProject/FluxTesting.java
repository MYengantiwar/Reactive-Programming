package com.reactive.ReactiveProject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reactive.ReactiveProject.service.FluxTestingService;

import reactor.test.StepVerifier;

@SpringBootTest
public class FluxTesting {

	@Autowired
	private FluxTestingService fluxservice;
	
	@Test
	public void test() {
		
		fluxservice.createFlux().subscribe(data -> {
			System.out.println("Getting data from Flux="+data);
		});
		System.out.println("---------------Calling fruitFlux-------------------");
		fluxservice.getFruitFlux().subscribe(data -> {
			System.out.println("Getting fruit names from fruit="+data);
		});
		System.out.println("---------------Calling mappedFlux-------------------");
		/*
		 * fluxservice.getFluxMapped().subscribe( data -> {
		 * System.out.println("Getting Data from mapped Flux="+data); });
		 */
		
		StepVerifier.create(fluxservice.getFluxMapped())
		            .expectNextCount(5)
		            .verifyComplete();
		
		System.out.println("-------------CreatingFilterFlux-------------------");
		fluxservice.getFilterFlux().subscribe( System.out :: println);
		
		System.out.println("-------------CreatingFlatmappedFlux-------------------");
		StepVerifier.create(fluxservice.getFlatMappedFlux())
					.expectNextCount(28)
					.verifyComplete();
		System.out.println("-------------CreatingTransformedFlux-------------------");
		fluxservice.getTransform().subscribe( System.out::println);
		
		System.out.println("-------------CreatingZipFlux-------------------");
		StepVerifier.create(fluxservice.getZip())
					.expectNextCount(5)
					.verifyComplete();
		
		System.out.println("-------------CreatingDoOnNextFlux-------------------");
		
		fluxservice.onSideEffect().subscribe( name -> {
			
		System.out.println("Getting name="+name);
		});
	}
}
