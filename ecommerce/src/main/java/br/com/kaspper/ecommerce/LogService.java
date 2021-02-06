package br.com.kaspper.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.regex.Pattern;

public class LogService {

    private void parse(ConsumerRecord<String, String> record) {
        System.out.println(" Processando e-mail , verificando por fralde ");
        System.out.println(" LOG: " + record.topic());
        System.out.println("Key: " + record.key());
        System.out.println("Value: " + record.value());
        System.out.println("Particao: " + record.partition());
        System.out.println("Offset: " + record.offset());
    }

    public static void main(String[] args) throws InterruptedException {

        var logService = new LogService();
        var service = new KafkaService(LogService.class.getSimpleName(), Pattern.compile("ECOMMERCE.*"), logService::parse);
        service.run();


    }


}
