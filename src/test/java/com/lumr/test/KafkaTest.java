package com.lumr.test;

import com.lumr.sbeam.config.KafkaConfigure;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.*;

/**
 * @author lumr
 * @since 2019/9/20 下午11:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {KafkaConfigure.class})
@TestPropertySource(locations = "/application.yml")
public class KafkaTest {

    @Autowired
    private KafkaConfigure kafkaConfigure;

    @Test
    public void productTest() {
        KafkaProducer<String, String> producer = new KafkaProducer<>(kafkaConfigure.getProducerProps());

        producer.send(new ProducerRecord<>("message", "bgu", "helloWord"), (metadata, exception) -> {
            System.out.println(metadata.toString());
        });

        producer.partitionsFor("message").forEach(System.out::println);
    }

    @Test
    public void consumeTest() {
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(kafkaConfigure.getConsumerProps());
        consumer.subscribe(Arrays.asList("message", "test"));
        boolean con = true;
        while (con) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(5));
            records.forEach(a -> System.out.printf("%s %s%n", a.key(), a.value()));
            for (ConsumerRecord<String, String> record : records) {
                if (record.value().equals("end")) {
                    con = false;
                }
            }
            consumer.commitAsync((a, e) -> {
                System.out.println("事务提交完成。" + a.toString());
            });
        }
        consumer.close();
    }

    @Test
    public void consumeTest1() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Future> a = new ArrayList<>();
        a.add(executorService.submit(() -> {
            consume("c1", "消费者1");
        }));
        a.add(executorService.submit(() -> {
            consume("c2", "消费者2");
        }));
        a.add(executorService.submit(() -> {
            consume("c1", "消费者3");
        }));

        for (Future future : a) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    private void consume(String group,String cname){
        Properties properties = (Properties) kafkaConfigure.getConsumerProps().clone();
        properties.put("group.id",group);
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList("message", "test"));
        boolean con = true;
        while (con) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(5));
            records.forEach(a -> System.out.printf("消费者[%s] %s %s%n", cname,a.key(), a.value()));
            for (ConsumerRecord<String, String> record : records) {
                if (record.value().equals("end")) {
                    con = false;
                }
            }
            consumer.commitAsync((a, e) -> {
                System.out.printf("%s事务提交完成。%s%n" , cname ,a.toString());
            });
        }
        consumer.close();
    }
}
