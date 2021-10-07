package cz.osu.student.r19584.chat.sender;

import java.util.*;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Sender implements CommandLineRunner {
	private final RabbitTemplate rabbitTemplate;
	private final Scanner scanner;

	@Autowired
	public Sender(RabbitTemplate rabbitTemplate, Scanner scanner) {
		this.rabbitTemplate = rabbitTemplate;
		this.scanner = scanner;
	}

	@Override
	public void run(String... args) throws Exception {
		while (true) {
			System.out.print("Enter message: ");
			String message = scanner.nextLine();
			rabbitTemplate.convertAndSend(SenderApplication.topicExchangeName, "foo.bar.baz", message);
			System.out.println("Sending message: " + message);
		}
	}
}
