package cz.osu.student.r19584.chat.sender;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class SenderApplication {
	static final String topicExchangeName = "r19584-exchange";
	static final String queueName = "r19584-queue";

	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(topicExchangeName);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
	}

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(SenderApplication.class, args);
	}

}
