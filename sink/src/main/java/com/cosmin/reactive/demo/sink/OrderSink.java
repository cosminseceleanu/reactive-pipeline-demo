package com.cosmin.reactive.demo.sink;

import com.cosmin.reactive.demo.domain.Order;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@EnableBinding(Sink.class)
@Service
public class OrderSink {

    @StreamListener(Sink.INPUT)
    public void receive(Flux<Order> orders) {
        orders.subscribe(System.out::println);
    }
}
