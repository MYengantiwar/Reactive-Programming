package com.reactive.ReactiveProject.service;

import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import ch.qos.logback.core.helpers.Transform;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

@Service
public class FluxTestingService {

	public void fluxServiceTesting() {
		System.out.println("Inside Flux service Testing");
	}
	
	public Flux<String> createFlux(){
		Flux<String> newFlux = Flux.just("Mayur" ,"Shubham","Hansraj","Ajay","Saheb");
		
		return newFlux;
	}
	
	public Flux<String> getFruitFlux(){
		
		List<String> fruitflux = List.of("Apple","Banana","Mango");
		return Flux.fromIterable(fruitflux);
	}
	
	public Flux<String> getFluxMapped(){
		return createFlux().map(data -> data.toUpperCase());
	}
	
	public Flux<String> getFilterFlux(){
		return createFlux().filter(name -> name.length() > 4);
	}
	
	public Flux<String> getFlatMappedFlux(){
		
		return createFlux().flatMap(name -> Flux.just(name.split(""))).log();
	}
	
	public Flux<Integer> getTransform(){
		
		Function<Flux<String>, Flux<Integer>> function = (name) -> name.map(String :: length);
		
		return createFlux().transform(function).log();
		
		
	}
	
	public Flux<Tuple2<String, Integer>> getZip(){
		
		Flux<Tuple2<String, Integer>> zip = Flux.zip(createFlux(), Flux.just(1,2,3,5,6,7)).log();	
		return zip;
	}
	
	public Flux<String> onSideEffect(){
		
	 return createFlux().doOnNext((data) -> {
		 System.out.println("Doing activity on Next Element ="+ data);
	 }).log();
	 
	}
}
