package com.cosmin.reactive.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    public final static String STATUS_NEW = "new";
    public final static String STATUS_PROCESSED = "processed";

    private LocalDateTime createdAt;
    private String status;
    private String details;
    private Product product;
}