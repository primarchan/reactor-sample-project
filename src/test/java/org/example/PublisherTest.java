package org.example;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class PublisherTest {

    private final Publisher publisher = new Publisher();

    @Test
    void startFlux1() {
        StepVerifier.create(publisher.startFlux1())
                .expectNext(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .verifyComplete();
    }

    @Test
    void startFlux2() {
        StepVerifier.create(publisher.startFlux2())
                .expectNext("a", "b", "c", "d", "e")
                .verifyComplete();
    }

    @Test
    void startMono1() {
        StepVerifier.create(publisher.startMono1())
                .expectNext(1)
                .verifyComplete();
    }

    @Test
    void startMono2() {
        StepVerifier.create(publisher.startMono2())
                .expectNext()
                .verifyComplete();
    }

    @Test
    void startMono3() {
        StepVerifier.create(publisher.startMono3())
                .expectError(Exception.class)
                .verify();
    }

}