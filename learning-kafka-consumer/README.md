# learning-kafka-consumer project

This project uses Quarkus (https://quarkus.io/) to create a very simple **Kafka Consumer** that reads data from a Kafka topic and saves it to a table in PostgreSQL.

To test:

1. Follow the steps on the **learning-kafka-producer** project to send data to a Kafka topic.
2. Create a PostgreSQL database called **test_kafka**.
3. Edit the src/main/resources/application.properties and change the database connection parameters. 
4. Run the consumer in dev mode:

```
./mvnw quarkus:dev
```
5. As new events become available in the topic **products**, they will be read by the consumer and recorded in the **product** table of the database.
