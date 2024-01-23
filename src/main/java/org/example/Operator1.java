package org.example;

import reactor.core.publisher.Flux;

public class Operator1 {

    // Map
    public Flux<Integer> fluxMap() {
        return Flux.range(1, 5)
                .map(i -> i * 2)
                .log();
    }

    // Filter
    public Flux<Integer> fluxFilter() {
        return Flux.range(1, 10)
                .filter(i -> i > 5)
                .log();
    }

    // Take
    public Flux<Integer> fluxTake() {
        return Flux.range(1, 10)
                .filter(i -> i > 5)
                .take(3)
                .log();
    }

    // Flatmap
    public Flux<Integer> fluxFlatMap1() {
        return Flux.range(1, 10)
                .flatMap(i -> Flux.range(i * 10, 10))
                .log();
    }

    public Flux<Integer> fluxFlatMap2() {
        return Flux.range(1, 9)
                .flatMap(i -> Flux.range( 1, 9)
                        .map(j -> {
                            System.out.printf("%d * %d = %d\n", i, j, i * j);
                            return i * j;
                        }))
                .log();
    }

}
