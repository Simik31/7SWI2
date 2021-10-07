package cz.osu.student.r19584.chat.receiver;

import org.springframework.stereotype.Component;

@Component
public class Receiver {
	public void receiveMessage(String message) {
		System.out.println("Received massage: " + message + "");
	}
}
