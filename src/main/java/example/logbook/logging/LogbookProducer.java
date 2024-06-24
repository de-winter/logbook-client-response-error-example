package example.logbook.logging;

import jakarta.enterprise.inject.Produces;
import org.zalando.logbook.Logbook;

public class LogbookProducer {
    @Produces
    public Logbook logbook() {
        return Logbook.create();
    }
}
