package meetup.app;

import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.core.annotation.ReflectiveAccess;
import jakarta.inject.Inject;
import java.util.concurrent.Callable;
import meetup.app.core.MessageProvider;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "meetup", version = "meetup 1.0", description = "Prints hello message for meetup.")
@ReflectiveAccess
public class MeetupApp implements Callable<Integer> {

    @Option(names = {"--name"}, description = "Enter your name here.")
    private String name;

    @Inject
    private MessageProvider messageProvider;

    @Override
    public Integer call() {
        System.out.println(messageProvider.greeting(name));
        return 0;
    }

    public static void main(String... args) {
        PicocliRunner.execute(MeetupApp.class, args);
    }
}

