package com.ms.user.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.user.core.ports.out.QueuePort;
import com.ms.user.infrastructure.queueProducer.RabbitProducer;

@Configuration
public class RabbitMqConfig {

   @Value("${spring.rabbitmq.addresses}")
   String rabbitUrl;

   @Bean(name = "queuePortBean")
   public QueuePort queuePort() {
      CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
      connectionFactory.setUri(this.rabbitUrl);
      RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

      ObjectMapper objectMapper = new ObjectMapper();
      rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter(objectMapper));
      
      return new RabbitProducer(rabbitTemplate);
   }

}
