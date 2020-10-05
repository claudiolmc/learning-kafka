# learning-kafka-producer project

This project uses Quarkus (https://quarkus.io/) to create a very simple endpoint that implements a Kafka Producer and send data to a Kafka topic.

To test:

1. Follow the steps on [Kafka Quickstart](http://kafka.apache.org/quickstart) to download and run Kafka on your machine.

2. Run the producer in dev mode:

```
./mvnw quarkus:dev
```

3. Make a HTTP POST call to http://localhost:8080/product sending a json like:
```
{
    "gtin": "7897982206000",
    "description": "Teclado USB Preto Bright",
    "brand": "Bright",
    "category": "Keyboard"
}
```

If you use [Postman](https://www.postman.com/) you can use the collection 
**learning-kafka.postman_collection.json** inside the project to call the endpoint.