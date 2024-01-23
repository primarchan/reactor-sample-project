package org.example;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

public class Operator2 {

    // Concatmap
    public Flux<Integer> fluxConcatMap() {
        return Flux.range(1, 10)
                .concatMap(i -> Flux.range(i * 10, 10)
                        .delayElements(Duration.ofMillis(10)))
                .log();
    }

    // flatmapMany
    public Flux<Integer> monoFlatMapMany() {
        return Mono.just(10)
                .flatMapMany(i -> Flux.range(1, i));
    }

    // defaultIfEmpty
    public Mono<Integer> defaultIfEmpty() {
        return Mono.just(100)
                .filter(i -> i > 100)
                .defaultIfEmpty(30);
    }

    // switchIfEmpty
    public Mono<Integer> switchIfEmpty1() {
        return Mono.just(100)
                .filter(i -> i > 100)
                .switchIfEmpty(Mono.just(30).map(i -> i * 2));
    }

    public Mono<Integer> switchIfEmpty2() {
        return Mono.just(100)
                .filter(i -> i > 100)
                .switchIfEmpty(Mono.error(new Exception("Not exists value...")));
    }

    // Merge
    public Flux<String> fluxMerge() {
        return Flux.merge(Flux.fromIterable(List.of("1", "2", "3")), Flux.just("4")).log();
    }

    public Flux<String> monoMerge() {
        return Mono.just("1").mergeWith(Mono.just("2")).mergeWith(Mono.just("3"));
    }

    // Zip
    public Flux<String> fluxZip() {
        return Flux.zip(Flux.just("a", "b", "c"), Flux.just("d", "e", "f"))
                .map(i -> i.getT1() + i.getT2())
                .log();
    }

    public Mono<Integer> monoZip() {
        return Mono.zip(Mono.just(1), Mono.just(2), Mono.just(3))
                .map(i -> i.getT1() + i.getT2() + i.getT3());
    }

}
