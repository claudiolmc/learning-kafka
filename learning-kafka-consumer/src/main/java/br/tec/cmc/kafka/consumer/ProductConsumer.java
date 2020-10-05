package br.tec.cmc.kafka.consumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.json.JSONObject;

import br.tec.cmc.kafka.entity.Product;
import br.tec.cmc.kafka.repository.ProductRepository;

public class ProductConsumer extends Thread {
    
    private ProductRepository repo;

    public ProductConsumer(ProductRepository repo) {
        this.repo = repo;
    }

    public void run() {

        System.out.println(">>>>> RUNNING CONSUMER!!!");

        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "localhost:9092");
        props.setProperty("group.id", "test");
        props.setProperty("enable.auto.commit", "true");
        props.setProperty("auto.commit.interval.ms", "1000");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("products"));
        
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> record : records) {

                JSONObject jso = new JSONObject(record.value());
                System.out.println(jso.toString());

                Product prod = new Product();
                prod.setGtin(jso.optString("gtin"));
                prod.setDescription(jso.optString("description"));
                prod.setBrand(jso.optString("brand"));
                prod.setCategory(jso.optString("category"));

                repo.save(prod);
            }
        }
    }
}
