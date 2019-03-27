package com.cosmin.reactive.demo.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {
    public final static String STATUS_NEW = "new";
    public final static String STATUS_PROCESSED = "processed";

    private final LocalDateTime createdAt;
    private final String status;
    private final String details;
    private final Product product;
}
