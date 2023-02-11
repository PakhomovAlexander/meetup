package meetup.app.core;

import jakarta.inject.Singleton;
import java.util.List;
import java.util.Random;

@Singleton
public class MessageProvider {
    private static final String DEFAULT_NAME = "Sasha";

    private static final List<String> listOfGreetings;
    static {
        listOfGreetings = List.of(
                "What an awesome meetup!", "I love meetups!",
                        "I love Yerevan!", "We love Java!", "We love native!"
                );
    }

    public String greeting(String name) {
        return "Hello " + (name == null ? DEFAULT_NAME : name) + "! " + randomGreeting();
    }

    private String randomGreeting() {
        return listOfGreetings.get(new Random().nextInt(listOfGreetings.size()));
    }
}


