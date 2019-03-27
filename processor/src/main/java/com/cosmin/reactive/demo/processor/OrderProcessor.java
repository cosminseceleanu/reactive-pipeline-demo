package com.cosmin.reactive.demo.processor;

import com.cosmin.reactive.demo.domain.Order;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@EnableBinding(Processor.class)
public class OrderProcessor {

    @StreamListener
    @Output(Processor.OUTPUT)
    public Flux<Order> confirm(@Input(Processor.INPUT) Flux<Order> input) {
        return input.map(order -> new Order(
                order.getCreatedAt(),
                Order.STATUS_PROCESSED,
                order.getDetails(),
                order.getProduct()
        ));
    }
}
