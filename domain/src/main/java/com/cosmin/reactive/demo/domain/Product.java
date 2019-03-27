package com.cosmin.reactive.demo.domain;

import lombok.Data;

@Data
public class Product {
    private final Integer id;
    private final String name;
    private final Double price;
}
