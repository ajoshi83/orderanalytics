package com.poc.kafka.orderanalytics.consumer;

import com.poc.kafka.orderanalytics.events.OrderEvent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class OrderEventConsumer {
    @Bean
    public Consumer<OrderEvent> processOrder() {
        log.info("Consuming the order");
        return orderEvent -> {
          log.info("Order Consumed with category: {}, name: {}, qty: {}",orderEvent.getCategory(), orderEvent.getName(), orderEvent.getQuantity());
        };
    }
}
