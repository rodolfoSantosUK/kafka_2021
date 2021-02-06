package br.com.kaspper.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class FraudDetectorService {

    private void parse(ConsumerRecord<String, String> record) {
        System.out.println(" Processando nova ordem, verificando por fralde ");
        System.out.println("Key " + record.key());
        System.out.println("Value " + record.value());
        System.out.println("Particao " + record.partition());
        System.out.println("Offset " + record.offset());
    }

    public static void main(String[] args) throws InterruptedException {
        var fraudService = new FraudDetectorService();
        var service = new KafkaService(FraudDetectorService.class.getSimpleName(),"ECOMMERCE_NEW_ORDER", fraudService :: parse);
        service.run();
  }



}
