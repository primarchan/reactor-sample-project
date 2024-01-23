package org.example;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class Operator3Test {

    private final Operator3 operator3 = new Operator3();

    @Test
    void monoCount() {
        StepVerifier.create(operator3.monoCount())
                .expectNext(10L)
                .verifyComplete();
    }

    @Test
    void fluxDistinct() {
        StepVerifier.create(operator3.fluxDistinct())
                .expectNext("a", "b", "c")
                .verifyComplete();
    }

    @Test
    void reduceMono() {
        StepVerifier.create(operator3.reduceMono())
                .expectNext(55)
                .verifyComplete();
    }

    @Test
    void fluxGroupBy() {
        StepVerifier.create(operator3.fluxGroupBy())
                .expectNext(30)
                .expectNext(25)
                .verifyComplete();
    }

}