package br.com.kaspper.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class EmailService {

    private void parse(ConsumerRecord<String, String> record) {
        System.out.println("-----------------------------------------");
        System.out.println(" Processando e-mail , verificando por fralde ");
        System.out.println("Key " + record.key());
        System.out.println("Value " + record.value());
        System.out.println("Particao " + record.partition());
        System.out.println("Offset " + record.offset());
    }

    public static void main(String[] args) throws InterruptedException {

        var emailService = new EmailService();
        var service = new KafkaService(FraudDetectorService.class.getSimpleName(), "ECOMMERCE_SEND_EMAIL", emailService::parse);
        service.run();


    }

}


