package com.cosmin.reactive.demo.source;

import com.cosmin.reactive.demo.domain.Order;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.reactive.StreamEmitter;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
@AllArgsConstructor
@EnableBinding(Source.class)
public class OrderEmitter {
    private final RandomOrderGenerator orderGenerator;

    @StreamEmitter
    @Output(Source.OUTPUT)
    public Flux<Order> emit() {
        return Flux.interval(Duration.ofMillis(50))
                .map(d -> orderGenerator.generate());
    }
}
