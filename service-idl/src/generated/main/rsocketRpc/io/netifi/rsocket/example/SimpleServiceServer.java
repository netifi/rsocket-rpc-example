package io.netifi.rsocket.example;

@javax.annotation.Generated(
    value = "by RSocket RPC proto compiler",
    comments = "Source: service.proto")
@io.rsocket.rpc.annotations.internal.Generated(
    type = io.rsocket.rpc.annotations.internal.ResourceType.SERVICE,
    idlClass = SimpleService.class)
@javax.inject.Named(
    value ="SimpleServiceServer")
public final class SimpleServiceServer extends io.rsocket.rpc.AbstractRSocketService {
  private final SimpleService service;
  private final io.opentracing.Tracer tracer;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<io.rsocket.Payload>, ? extends org.reactivestreams.Publisher<io.rsocket.Payload>> requestReply;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<io.rsocket.Payload>, ? extends org.reactivestreams.Publisher<io.rsocket.Payload>> fireAndForget;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<io.rsocket.Payload>, ? extends org.reactivestreams.Publisher<io.rsocket.Payload>> requestStream;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<io.rsocket.Payload>, ? extends org.reactivestreams.Publisher<io.rsocket.Payload>> streamingRequestSingleResponse;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<io.rsocket.Payload>, ? extends org.reactivestreams.Publisher<io.rsocket.Payload>> streamingRequestAndResponse;
  private final java.util.function.Function<io.opentracing.SpanContext, java.util.function.Function<? super org.reactivestreams.Publisher<io.rsocket.Payload>, ? extends org.reactivestreams.Publisher<io.rsocket.Payload>>> requestReplyTrace;
  private final java.util.function.Function<io.opentracing.SpanContext, java.util.function.Function<? super org.reactivestreams.Publisher<io.rsocket.Payload>, ? extends org.reactivestreams.Publisher<io.rsocket.Payload>>> fireAndForgetTrace;
  private final java.util.function.Function<io.opentracing.SpanContext, java.util.function.Function<? super org.reactivestreams.Publisher<io.rsocket.Payload>, ? extends org.reactivestreams.Publisher<io.rsocket.Payload>>> requestStreamTrace;
  private final java.util.function.Function<io.opentracing.SpanContext, java.util.function.Function<? super org.reactivestreams.Publisher<io.rsocket.Payload>, ? extends org.reactivestreams.Publisher<io.rsocket.Payload>>> streamingRequestSingleResponseTrace;
  private final java.util.function.Function<io.opentracing.SpanContext, java.util.function.Function<? super org.reactivestreams.Publisher<io.rsocket.Payload>, ? extends org.reactivestreams.Publisher<io.rsocket.Payload>>> streamingRequestAndResponseTrace;
  @javax.inject.Inject
  public SimpleServiceServer(SimpleService service, java.util.Optional<io.micrometer.core.instrument.MeterRegistry> registry, java.util.Optional<io.opentracing.Tracer> tracer) {
    this.service = service;
    if (!registry.isPresent()) {
      this.requestReply = java.util.function.Function.identity();
      this.fireAndForget = java.util.function.Function.identity();
      this.requestStream = java.util.function.Function.identity();
      this.streamingRequestSingleResponse = java.util.function.Function.identity();
      this.streamingRequestAndResponse = java.util.function.Function.identity();
    } else {
      this.requestReply = io.rsocket.rpc.metrics.Metrics.timed(registry.get(), "rsocket.server", "service", SimpleService.SERVICE, "method", SimpleService.METHOD_REQUEST_REPLY);
      this.fireAndForget = io.rsocket.rpc.metrics.Metrics.timed(registry.get(), "rsocket.server", "service", SimpleService.SERVICE, "method", SimpleService.METHOD_FIRE_AND_FORGET);
      this.requestStream = io.rsocket.rpc.metrics.Metrics.timed(registry.get(), "rsocket.server", "service", SimpleService.SERVICE, "method", SimpleService.METHOD_REQUEST_STREAM);
      this.streamingRequestSingleResponse = io.rsocket.rpc.metrics.Metrics.timed(registry.get(), "rsocket.server", "service", SimpleService.SERVICE, "method", SimpleService.METHOD_STREAMING_REQUEST_SINGLE_RESPONSE);
      this.streamingRequestAndResponse = io.rsocket.rpc.metrics.Metrics.timed(registry.get(), "rsocket.server", "service", SimpleService.SERVICE, "method", SimpleService.METHOD_STREAMING_REQUEST_AND_RESPONSE);
    }

    if (!tracer.isPresent()) {
      this.tracer = null;
      this.requestReplyTrace = io.rsocket.rpc.tracing.Tracing.traceAsChild();
      this.fireAndForgetTrace = io.rsocket.rpc.tracing.Tracing.traceAsChild();
      this.requestStreamTrace = io.rsocket.rpc.tracing.Tracing.traceAsChild();
      this.streamingRequestSingleResponseTrace = io.rsocket.rpc.tracing.Tracing.traceAsChild();
      this.streamingRequestAndResponseTrace = io.rsocket.rpc.tracing.Tracing.traceAsChild();
    } else {
      this.tracer = tracer.get();
      this.requestReplyTrace = io.rsocket.rpc.tracing.Tracing.traceAsChild(this.tracer, SimpleService.METHOD_REQUEST_REPLY, io.rsocket.rpc.tracing.Tag.of("rsocket.service", SimpleService.SERVICE), io.rsocket.rpc.tracing.Tag.of("rsocket.rpc.role", "server"), io.rsocket.rpc.tracing.Tag.of("rsocket.rpc.version", ""));
      this.fireAndForgetTrace = io.rsocket.rpc.tracing.Tracing.traceAsChild(this.tracer, SimpleService.METHOD_FIRE_AND_FORGET, io.rsocket.rpc.tracing.Tag.of("rsocket.service", SimpleService.SERVICE), io.rsocket.rpc.tracing.Tag.of("rsocket.rpc.role", "server"), io.rsocket.rpc.tracing.Tag.of("rsocket.rpc.version", ""));
      this.requestStreamTrace = io.rsocket.rpc.tracing.Tracing.traceAsChild(this.tracer, SimpleService.METHOD_REQUEST_STREAM, io.rsocket.rpc.tracing.Tag.of("rsocket.service", SimpleService.SERVICE), io.rsocket.rpc.tracing.Tag.of("rsocket.rpc.role", "server"), io.rsocket.rpc.tracing.Tag.of("rsocket.rpc.version", ""));
      this.streamingRequestSingleResponseTrace = io.rsocket.rpc.tracing.Tracing.traceAsChild(this.tracer, SimpleService.METHOD_STREAMING_REQUEST_SINGLE_RESPONSE, io.rsocket.rpc.tracing.Tag.of("rsocket.service", SimpleService.SERVICE), io.rsocket.rpc.tracing.Tag.of("rsocket.rpc.role", "server"), io.rsocket.rpc.tracing.Tag.of("rsocket.rpc.version", ""));
      this.streamingRequestAndResponseTrace = io.rsocket.rpc.tracing.Tracing.traceAsChild(this.tracer, SimpleService.METHOD_STREAMING_REQUEST_AND_RESPONSE, io.rsocket.rpc.tracing.Tag.of("rsocket.service", SimpleService.SERVICE), io.rsocket.rpc.tracing.Tag.of("rsocket.rpc.role", "server"), io.rsocket.rpc.tracing.Tag.of("rsocket.rpc.version", ""));
    }

  }

  @java.lang.Override
  public String getService() {
    return SimpleService.SERVICE;
  }

  @java.lang.Override
  public Class<?> getServiceClass() {
    return service.getClass();
  }

  @java.lang.Override
  public reactor.core.publisher.Mono<Void> fireAndForget(io.rsocket.Payload payload) {
    return reactor.core.publisher.Mono.error(new UnsupportedOperationException("Fire and forget not implemented."));
  }

  @java.lang.Override
  public reactor.core.publisher.Mono<io.rsocket.Payload> requestResponse(io.rsocket.Payload payload) {
    try {
      io.netty.buffer.ByteBuf metadata = payload.sliceMetadata();
      io.opentracing.SpanContext spanContext = io.rsocket.rpc.tracing.Tracing.deserializeTracingMetadata(tracer, metadata);
      switch(io.rsocket.rpc.frames.Metadata.getMethod(metadata)) {
        case SimpleService.METHOD_REQUEST_REPLY: {
          com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(payload.getData());
          return service.requestReply(io.netifi.rsocket.example.SimpleRequest.parseFrom(is), metadata).map(serializer).transform(requestReply).transform(requestReplyTrace.apply(spanContext));
        }
        case SimpleService.METHOD_FIRE_AND_FORGET: {
          com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(payload.getData());
          return service.fireAndForget(io.netifi.rsocket.example.SimpleRequest.parseFrom(is), metadata).map(serializer).transform(fireAndForget).transform(fireAndForgetTrace.apply(spanContext));
        }
        default: {
          return reactor.core.publisher.Mono.error(new UnsupportedOperationException());
        }
      }
    } catch (Throwable t) {
      return reactor.core.publisher.Mono.error(t);
    } finally {
      payload.release();
    }
  }

  @java.lang.Override
  public reactor.core.publisher.Flux<io.rsocket.Payload> requestStream(io.rsocket.Payload payload) {
    try {
      io.netty.buffer.ByteBuf metadata = payload.sliceMetadata();
      io.opentracing.SpanContext spanContext = io.rsocket.rpc.tracing.Tracing.deserializeTracingMetadata(tracer, metadata);
      switch(io.rsocket.rpc.frames.Metadata.getMethod(metadata)) {
        case SimpleService.METHOD_REQUEST_STREAM: {
          com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(payload.getData());
          return service.requestStream(io.netifi.rsocket.example.SimpleRequest.parseFrom(is), metadata).map(serializer).transform(requestStream).transform(requestStreamTrace.apply(spanContext));
        }
        default: {
          return reactor.core.publisher.Flux.error(new UnsupportedOperationException());
        }
      }
    } catch (Throwable t) {
      return reactor.core.publisher.Flux.error(t);
    } finally {
      payload.release();
    }
  }

  @java.lang.Override
  public reactor.core.publisher.Flux<io.rsocket.Payload> requestChannel(io.rsocket.Payload payload, reactor.core.publisher.Flux<io.rsocket.Payload> publisher) {
    try {
      io.netty.buffer.ByteBuf metadata = payload.sliceMetadata();
      io.opentracing.SpanContext spanContext = io.rsocket.rpc.tracing.Tracing.deserializeTracingMetadata(tracer, metadata);
      switch(io.rsocket.rpc.frames.Metadata.getMethod(metadata)) {
        case SimpleService.METHOD_STREAMING_REQUEST_SINGLE_RESPONSE: {
          reactor.core.publisher.Flux<io.netifi.rsocket.example.SimpleRequest> messages =
            publisher.map(deserializer(io.netifi.rsocket.example.SimpleRequest.parser()));
          return service.streamingRequestSingleResponse(messages, metadata).map(serializer).transform(streamingRequestSingleResponse).transform(streamingRequestSingleResponseTrace.apply(spanContext)).flux();
        }
        case SimpleService.METHOD_STREAMING_REQUEST_AND_RESPONSE: {
          reactor.core.publisher.Flux<io.netifi.rsocket.example.SimpleRequest> messages =
            publisher.map(deserializer(io.netifi.rsocket.example.SimpleRequest.parser()));
          return service.streamingRequestAndResponse(messages, metadata).map(serializer).transform(streamingRequestAndResponse).transform(streamingRequestAndResponseTrace.apply(spanContext));
        }
        default: {
          return reactor.core.publisher.Flux.error(new UnsupportedOperationException());
        }
      }
    } catch (Throwable t) {
      return reactor.core.publisher.Flux.error(t);
    }
  }

  @java.lang.Override
  public reactor.core.publisher.Flux<io.rsocket.Payload> requestChannel(org.reactivestreams.Publisher<io.rsocket.Payload> payloads) {
    return new io.rsocket.internal.SwitchTransformFlux<io.rsocket.Payload, io.rsocket.Payload>(payloads, new java.util.function.BiFunction<io.rsocket.Payload, reactor.core.publisher.Flux<io.rsocket.Payload>, org.reactivestreams.Publisher<? extends io.rsocket.Payload>>() {
      @java.lang.Override
      public org.reactivestreams.Publisher<io.rsocket.Payload> apply(io.rsocket.Payload payload, reactor.core.publisher.Flux<io.rsocket.Payload> publisher) {
        return requestChannel(payload, publisher);
      }
    });
  }

  private static final java.util.function.Function<com.google.protobuf.MessageLite, io.rsocket.Payload> serializer =
    new java.util.function.Function<com.google.protobuf.MessageLite, io.rsocket.Payload>() {
      @java.lang.Override
      public io.rsocket.Payload apply(com.google.protobuf.MessageLite message) {
        int length = message.getSerializedSize();
        io.netty.buffer.ByteBuf byteBuf = io.netty.buffer.ByteBufAllocator.DEFAULT.buffer(length);
        try {
          message.writeTo(com.google.protobuf.CodedOutputStream.newInstance(byteBuf.internalNioBuffer(0, length)));
          byteBuf.writerIndex(length);
          return io.rsocket.util.ByteBufPayload.create(byteBuf);
        } catch (Throwable t) {
          byteBuf.release();
          throw new RuntimeException(t);
        }
      }
    };

  private static <T> java.util.function.Function<io.rsocket.Payload, T> deserializer(final com.google.protobuf.Parser<T> parser) {
    return new java.util.function.Function<io.rsocket.Payload, T>() {
      @java.lang.Override
      public T apply(io.rsocket.Payload payload) {
        try {
          com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(payload.getData());
          return parser.parseFrom(is);
        } catch (Throwable t) {
          throw new RuntimeException(t);
        } finally {
          payload.release();
        }
      }
    };
  }
}
