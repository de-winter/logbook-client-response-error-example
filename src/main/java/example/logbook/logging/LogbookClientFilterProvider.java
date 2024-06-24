package example.logbook.logging;

import jakarta.inject.Inject;
import jakarta.ws.rs.ConstrainedTo;
import jakarta.ws.rs.RuntimeType;
import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import jakarta.ws.rs.client.ClientResponseContext;
import jakarta.ws.rs.client.ClientResponseFilter;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.WriterInterceptor;
import jakarta.ws.rs.ext.WriterInterceptorContext;
import org.zalando.logbook.jaxrs.LogbookClientFilter;

import java.io.IOException;

@Provider
@ConstrainedTo(RuntimeType.CLIENT)
public class LogbookClientFilterProvider implements ClientRequestFilter, ClientResponseFilter, WriterInterceptor {
    @Inject
    LogbookClientFilter logbookClientFilter;

    @Override
    public void filter(final ClientRequestContext requestContext) throws IOException {
        logbookClientFilter.filter(requestContext);
    }

    @Override
    public void filter(final ClientRequestContext requestContext, final ClientResponseContext responseContext) {
        // BREAKING:
        logbookClientFilter.filter(requestContext, responseContext);
    }

    @Override
    public void aroundWriteTo(final WriterInterceptorContext context) throws IOException {
        logbookClientFilter.aroundWriteTo(context);
    }
}
