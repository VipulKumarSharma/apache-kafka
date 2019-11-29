# Apache Kafka

### START ZOOKEEPER
  
    zookeeper-server-start.bat C:\kafka_2.12-2.3.1\config\zookeeper.properties

### START KAFKA SERVER

    kafka-server-start.bat C:\kafka_2.12-2.3.1\config\server.properties

### CREATE TOPIC

    kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 -topic Kafka_Topic
    kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 -topic User_Topic

### PRODUCE MESSAGE
    
    kafka-console-producer.bat --broker-list localhost:9092 --topic Kafka_Topic
    kafka-console-producer.bat --broker-list localhost:9092 --topic User_Topic

### CONSUME A MESSAGE

    kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic Kafka_Topic --from-beginning
    kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic User_Topic --from-beginning

### Steps ::

* Start Zookeeper first, then Kafka server 
* Create Topics
* Start Producer then consumer project
* Test using below endpoints

<i>Note :- Place Download & extracted Kafka package in C Drive, otherwise it will give error regarding long command. 
And Launch the batch files stored in `...\bin\windows\` folder.</i>

### Publish Data 
    
[GET] [http://localhost:8081/kafka/publish/{username}](http://localhost:8081/kafka/publish/{username})

[POST] [http://localhost:8081/kafka/publish/user](http://localhost:8081/kafka/publish/user)

### Get Latest Consumed Data

[GET] [http://localhost:8082/kafka/consume/string](http://localhost:8082/kafka/consume/string)

[GET] [http://localhost:8082/kafka/consume/user](http://localhost:8082/kafka/consume/user)

### Database

[URL] [http://localhost:8082/h2](http://localhost:8082/h2)

[H2 JDBC] `jdbc:h2:mem:testdb`


### Sample Model

    {"id":454,"name":"Testing","address":"New Delhi, India"}
