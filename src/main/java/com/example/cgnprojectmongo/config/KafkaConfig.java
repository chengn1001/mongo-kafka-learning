//package com.example.cgnprojectmongo.config;
//
//import com.example.cgnprojectmongo.domain.User;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.*;
//
//import org.springframework.kafka.support.serializer.JsonDeserializer;
//import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
//import org.springframework.kafka.support.serializer.JsonSerializer;
//
//import java.util.HashMap;
//import java.util.Map;
//@Configuration
//public class KafkaConfig {
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, User> kafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, User> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }
//
//    @Bean
//    public ConsumerFactory<String, User> consumerFactory() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092,localhost:9094，localhost:9095");
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, "cgnGroup");
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
//        props.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, new JsonDeserializer<>(User.class));
//        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*"); // 允许反序列化任何包中的类
//        props.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, false); // 如果你不使用类型信息头
//        return new DefaultKafkaConsumerFactory<>(props);
//    }
//
////    @Bean
////    public KafkaTemplate<String, User> kafkaTemplate() {
////        return new KafkaTemplate<>(producerFactory());
////    }
////
////    @Bean
////    public ProducerFactory<String, User> producerFactory() {
////        return new DefaultKafkaProducerFactory<>(producerConfigs());
////    }
////
////    @Bean
////    public Map<String, Object> producerConfigs() {
////        Map<String, Object> props = new HashMap<>();
////        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
////        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
////        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
////        return props;
////    }
//}