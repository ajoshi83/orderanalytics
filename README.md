# orderanalytics
SpringBoot Kafka integration POC

#*Steps to run*
1. Run Apache Kafka on your local machine (with Zookeeper support)
2. Create a topic `ProductOrders` (Here we choose replication factor 1 as we are running single node Kafka cluster and partition as 3)

    ./bin/windows/kafka-topics.bat --create --topic ProductOrders --replication-factor 1 --partitions 3 --bootstrap-server localhost:9092
3. Verify, the topic `ProductOrders` is created

    ./bin/windows/kafka-topics.bat --describe --topic ProductOrders --bootstrap-server localhost:9092
4. Build the spring-boot application and run it through the IDE or using gradle command line `gradle bootRun`

#*Expectations*
1. Application should publish `OrderEvent` on topic `ProductOrders` and consume event from topic `ProductOrders`
2. Application should show the INFO logs:

    Configuring Order Data
    
    Creating order
    
    Consuming the order
    
    Order Consumed with category: aaa, name: bbb, qty: 1
