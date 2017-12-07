package com.anpjavatech.rabbitmq.configuration;

import com.anpjavatech.rabbitmq.listener.RabbitMQListener;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {


    @Bean(name = "test_exchange")
    public TopicExchange createExchange() {
        return new TopicExchange("reciever-exchange-name");
    }

    @Bean(name = "test_queue")
    public Queue createQueue() {
        return new Queue("reciever-queue-name");
    }

    @Bean
    public Binding createBinding(@Qualifier("test_exchange") TopicExchange exchange, @Qualifier("test_queue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("*");
    }

    @Bean
    public SimpleMessageListenerContainer createListener(ConnectionFactory connectionFactory, RabbitMQListener listener) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("reciever-queue-name");
        container.setMessageListener(listener);
        return container;
    }
}
