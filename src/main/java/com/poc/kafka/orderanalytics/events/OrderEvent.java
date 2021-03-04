package com.poc.kafka.orderanalytics.events;

import lombok.Data;

@Data
public class OrderEvent {
    private String name;
    private String category;
    private int quantity;
}
