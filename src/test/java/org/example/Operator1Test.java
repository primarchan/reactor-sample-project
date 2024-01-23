package org.example;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class Operator1Test {

    private final Operator1 operator1 = new Operator1();

    @Test
    void fluxMap() {
        StepVerifier.create(operator1.fluxMap())
                .expectNext(2, 4, 6, 8, 10)
                .verifyComplete();

    }

    @Test
    void fluxFilter() {
        StepVerifier.create(operator1.fluxFilter())
                .expectNext(6, 7, 8,9, 10)
                .verifyComplete();
    }

    @Test
    void fluxTake() {
        StepVerifier.create(operator1.fluxTake())
                .expectNext(6, 7, 8)
                .verifyComplete();
    }

    @Test
    void fluxFlatMap1() {
        StepVerifier.create(operator1.fluxFlatMap1())
                .expectNextCount(100)
                .verifyComplete();
    }

    @Test
    void fluxFlatMap2() {
        StepVerifier.create(operator1.fluxFlatMap2())
                .expectNextCount(81)
                .verifyComplete();
    }

}