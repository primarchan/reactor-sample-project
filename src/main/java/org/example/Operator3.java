package org.example;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class Operator3 {

    // Count
    public Mono<Long> monoCount() {
        return Flux.range(1, 10)
                .count()
                .log();
    }

    // Distinct
    public Flux<String> fluxDistinct() {
        return Flux.fromIterable(List.of("a", "b", "a", "b", "c"))
                .distinct();
    }

    // Reduce
    public Mono<Integer> reduceMono() {
        return Flux.range(1, 10)
                .reduce((i, j) -> i + j)
                .log();
    }

    // groupBy
    public Flux<Integer> fluxGroupBy() {
        return Flux.range(1, 10)
                .groupBy(i -> (i % 2 == 0) ? "even" : "odd")
                .flatMap(group -> group.reduce(Integer::sum))
                .log();
    }

}
