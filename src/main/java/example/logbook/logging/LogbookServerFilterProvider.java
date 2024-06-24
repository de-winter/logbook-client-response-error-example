package example.logbook.logging;

import jakarta.inject.Inject;
import jakarta.ws.rs.ConstrainedTo;
import jakarta.ws.rs.RuntimeType;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.WriterInterceptor;
import jakarta.ws.rs.ext.WriterInterceptorContext;
import org.zalando.logbook.jaxrs.LogbookServerFilter;

import java.io.IOException;

@Provider
@ConstrainedTo(RuntimeType.SERVER)
public class LogbookServerFilterProvider implements ContainerRequestFilter, ContainerResponseFilter, WriterInterceptor {
    @Inject
    LogbookServerFilter logbookServerFilter;

    @Override
    public void filter(final ContainerRequestContext requestContext) throws IOException {
        logbookServerFilter.filter(requestContext);
    }

    @Override
    public void filter(final ContainerRequestContext requestContext, final ContainerResponseContext responseContext) {
        logbookServerFilter.filter(requestContext, responseContext);
    }

    @Override
    public void aroundWriteTo(final WriterInterceptorContext context) throws IOException, WebApplicationException {
        logbookServerFilter.aroundWriteTo(context);
    }
}
