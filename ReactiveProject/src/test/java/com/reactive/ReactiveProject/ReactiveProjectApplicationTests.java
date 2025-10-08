package com.reactive.ReactiveProject;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple3;

@SpringBootTest
class ReactiveProjectApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testwithMono() throws InterruptedException {
		// Creating mono
		System.out.println("Testing with Mono");
		
	/*	Mono<String> errormono = Mono.error(new RuntimeException("Getting Runtime Exception"));
		
		Mono<String> m1 = Mono.just("Testing with Mayur")
				.log()
				.then(errormono);
		
		
		
		
		//subscribing mono
		m1.subscribe(data -> {
			System.out.println("Data is="+data);
		});*/
		
		//errormono.subscribe(System.out :: println);
		
		Mono<String> m1 = Mono.just("Geting data from mono 1");
		Mono<String> m2 = Mono.just("Getting Data from Mono 2");
		Mono<Integer> m3 = Mono.just(3);
		
		//using zip method
	/*	  Mono<Tuple3<String, String, Integer>> combinedmono = Mono.zip(m1, m2,m3);
		combinedmono.subscribe(data -> {
			System.out.println("data 1 from combined Mono="+data.getT1());
			System.out.println("data 2 from combined Mono="+data.getT2());
			System.out.println("data 3 from combined Mono="+data.getT3());
		});*/
		
		//Using zipwith method
	/*	Mono<Tuple2<String, Integer>> zipWith = m1.zipWith(m3);
		zipWith.subscribe( data -> {
			System.out.println("zipWith 1st data="+data.getT1());
			System.out.println("zipWith 2nd data="+data.getT2());
		}); */
		
		
		//using map method
	/*	Mono<String> mapwithUpperCase = m1.map(data -> data.toUpperCase());
		mapwithUpperCase.subscribe(data -> {
			System.out.println("Mapped Data"+data);
		});*/
		
		//using flatmono method
		
	/*	Mono<String[]> flatMap = m1.flatMap(data -> Mono.just(data.split(" ")));
		flatMap.subscribe(data ->{ 
			for (String value : data) {
				System.out.println(value); 
			}
		});*/
		
		//Using flatmapmany method
	/*	System.out.println("--------------Using flatmapmany method------------------------");
		Flux<String> flatMapMany = m1.flatMapMany(data -> Flux.just(data.split(" ")) );
		flatMapMany.subscribe(data -> {
			
				System.out.println("Data with flatmapMany="+data);
			
		});*/
		
		//Using concatwith method
	/*	System.out.println("--------------Using concatwith method------------------------");
		Flux<String> fluxdata = m1.concatWith(m2).log().delayElements(Duration.ofMillis(2000));
		fluxdata.subscribe( System.out::println );
		Thread.sleep(3000);*/
		}
}
