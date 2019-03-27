package com.cosmin.reactive.demo.source;

import com.cosmin.reactive.demo.domain.Order;
import com.cosmin.reactive.demo.domain.Product;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class RandomOrderGenerator {

    private final Product[] products = {
            new Product(1, "Samsung S10", 1000.5),
            new Product(2, "Iphone XS Max", 1200.99),
            new Product(3, "Huawei P30", 899d)
    };

    private final Random rand = new Random();

    public Order generate() {
        return new Order(
                LocalDateTime.now(),
                Order.STATUS_NEW,
                getRandAlphaNumericString(rand.nextInt(20)),
                products[rand.nextInt(2)]
        );
    }

    private String getRandAlphaNumericString(int size)
    {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());

            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }
}
