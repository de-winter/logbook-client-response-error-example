package example.logbook.logging;

import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.jaxrs.LogbookClientFilter;
import org.zalando.logbook.jaxrs.LogbookServerFilter;

public class LogbookFilterProducer {
    @Inject
    Logbook logbook;

    @Produces
    public LogbookClientFilter logbookClientFilter() {
        return new LogbookClientFilter(logbook);
    }

    @Produces
    public LogbookServerFilter logbookServerFilter() {
        return new LogbookServerFilter(logbook);
    }
}
