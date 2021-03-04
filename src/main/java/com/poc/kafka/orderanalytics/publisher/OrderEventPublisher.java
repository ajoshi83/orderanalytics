package com.poc.kafka.orderanalytics.publisher;

import com.poc.kafka.orderanalytics.events.OrderEvent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class OrderEventPublisher {
    @Bean
    public Supplier<OrderEvent> orderCreated() {
        log.info("Configuring Order Data");
        Map<String, String[]> orders = new HashMap<>();
        orders.put("home_appliances", new String[] {"Toaster","Grill","Veg Cutter"});
        orders.put("gardening", new String[] {"Coco Pit","Vermi Compost","Petunia Seeds"});
        orders.put("toys", new String[] {"Dump Truck","Fighter Jet","Fire Truck"});
        orders.put("books", new String[] {"Let Us C","Effective Java","Apache Kafka, complete guide"});
        orders.put("cloths", new String[] {"T Shirt","Short","Vests"});
        return () -> {
            log.info("Creating order");
            String category = (String) orders.keySet().toArray()[new Random().nextInt(orders.size())];
            String name = orders.get(category)[new Random().nextInt(orders.get(category).length)];
            OrderEvent orderEvent = new OrderEvent();
            orderEvent.setCategory(category);
            orderEvent.setName(name);
            orderEvent.setQuantity(1);
            return orderEvent;
        };
    }
}
