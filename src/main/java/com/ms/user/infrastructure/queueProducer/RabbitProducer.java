package com.ms.user.infrastructure.queueProducer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import com.ms.user.core.domain.UserDomain;
import com.ms.user.core.ports.out.QueuePort;
import com.ms.user.infrastructure.dto.EmailDto;

@Component
public class RabbitProducer implements QueuePort {

    final RabbitTemplate rabbitTemplate;

    @Value(value = "${broker.queue.email.name}")
    private String queueName;

    public RabbitProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void publicMessage(UserDomain user) {
        try {
            if (user.getEmail().equals(null)) {
                throw new Exception("Email is required to publish message on rabbit queue");
            }

            EmailDto email = new EmailDto();
            email.setEmailTo(user.getEmail());
            email.setSubject("Cadastro realizado com sucesso");
            email.setUserId(user.getId());
            email.setText(user.getName());

            rabbitTemplate.convertAndSend("", this.queueName, email);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
