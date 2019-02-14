package io.netifi.rsocket.example;

@javax.annotation.Generated(
    value = "by RSocket RPC proto compiler (version 0.2.12)",
    comments = "Source: service.proto")
@io.rsocket.rpc.annotations.internal.Generated(
    type = io.rsocket.rpc.annotations.internal.ResourceType.SERVICE,
    idlClass = BlockingSimpleService.class)
@javax.inject.Named(
    value ="BlockingSimpleServiceServer")
public final class BlockingSimpleServiceServer extends io.rsocket.rpc.AbstractRSocketService {
  private final BlockingSimpleService service;
  private final reactor.core.scheduler.Scheduler scheduler;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<io.rsocket.Payload>, ? extends org.reactivestreams.Publisher<io.rsocket.Payload>> requestReply;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<io.rsocket.Payload>, ? extends org.reactivestreams.Publisher<io.rsocket.Payload>> fireAndForget;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<io.rsocket.Payload>, ? extends org.reactivestreams.Publisher<io.rsocket.Payload>> requestStream;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<io.rsocket.Payload>, ? extends org.reactivestreams.Publisher<io.rsocket.Payload>> streamingRequestSingleResponse;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<io.rsocket.Payload>, ? extends org.reactivestreams.Publisher<io.rsocket.Payload>> streamingRequestAndResponse;
  @javax.inject.Inject
  public BlockingSimpleServiceServer(BlockingSimpleService service, java.util.Optional<reactor.core.scheduler.Scheduler> scheduler, java.util.Optional<io.micrometer.core.instrument.MeterRegistry> registry) {
    this.scheduler = scheduler.orElse(reactor.core.scheduler.Schedulers.elastic());
    this.service = service;
    if (!registry.isPresent()) {
      this.requestReply = java.util.function.Function.identity();
      this.fireAndForget = java.util.function.Function.identity();
      this.requestStream = java.util.function.Function.identity();
      this.streamingRequestSingleResponse = java.util.function.Function.identity();
      this.streamingRequestAndResponse = java.util.function.Function.identity();
    } else {
      this.requestReply = io.rsocket.rpc.metrics.Metrics.timed(registry.get(), "rsocket.server", "service", BlockingSimpleService.SERVICE_ID, "method", BlockingSimpleService.METHOD_REQUEST_REPLY);
      this.fireAndForget = io.rsocket.rpc.metrics.Metrics.timed(registry.get(), "rsocket.server", "service", BlockingSimpleService.SERVICE_ID, "method", BlockingSimpleService.METHOD_FIRE_AND_FORGET);
      this.requestStream = io.rsocket.rpc.metrics.Metrics.timed(registry.get(), "rsocket.server", "service", BlockingSimpleService.SERVICE_ID, "method", BlockingSimpleService.METHOD_REQUEST_STREAM);
      this.streamingRequestSingleResponse = io.rsocket.rpc.metrics.Metrics.timed(registry.get(), "rsocket.server", "service", BlockingSimpleService.SERVICE_ID, "method", BlockingSimpleService.METHOD_STREAMING_REQUEST_SINGLE_RESPONSE);
      this.streamingRequestAndResponse = io.rsocket.rpc.metrics.Metrics.timed(registry.get(), "rsocket.server", "service", BlockingSimpleService.SERVICE_ID, "method", BlockingSimpleService.METHOD_STREAMING_REQUEST_AND_RESPONSE);
    }

  }

  @java.lang.Override
  public String getService() {
    return BlockingSimpleService.SERVICE_ID;
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
      switch(io.rsocket.rpc.frames.Metadata.getMethod(metadata)) {
        case SimpleService.METHOD_REQUEST_REPLY: {
          com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(payload.getData());
          io.netifi.rsocket.example.SimpleRequest message = io.netifi.rsocket.example.SimpleRequest.parseFrom(is);
          return reactor.core.publisher.Mono.fromSupplier(() -> service.requestReply(message, metadata)).map(serializer).transform(requestReply).subscribeOn(scheduler);
        }
        case SimpleService.METHOD_FIRE_AND_FORGET: {
          com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(payload.getData());
          io.netifi.rsocket.example.SimpleRequest message = io.netifi.rsocket.example.SimpleRequest.parseFrom(is);
          return reactor.core.publisher.Mono.fromSupplier(() -> service.fireAndForget(message, metadata)).map(serializer).transform(fireAndForget).subscribeOn(scheduler);
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
      switch(io.rsocket.rpc.frames.Metadata.getMethod(metadata)) {
        case BlockingSimpleService.METHOD_REQUEST_STREAM: {
          com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(payload.getData());
          io.netifi.rsocket.example.SimpleRequest message = io.netifi.rsocket.example.SimpleRequest.parseFrom(is);
          return reactor.core.publisher.Flux.defer(() -> reactor.core.publisher.Flux.fromIterable(service.requestStream(message, metadata)).map(serializer).transform(requestStream)).subscribeOn(scheduler);
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
      switch(io.rsocket.rpc.frames.Metadata.getMethod(metadata)) {
        case BlockingSimpleService.METHOD_STREAMING_REQUEST_SINGLE_RESPONSE: {
          reactor.core.publisher.Flux<io.netifi.rsocket.example.SimpleRequest> messages =
            publisher.map(deserializer(io.netifi.rsocket.example.SimpleRequest.parser()));
          return reactor.core.publisher.Mono.fromSupplier(() -> service.streamingRequestSingleResponse(messages.toIterable(), metadata)).map(serializer).transform(streamingRequestSingleResponse).flux().subscribeOn(scheduler);
        }
        case BlockingSimpleService.METHOD_STREAMING_REQUEST_AND_RESPONSE: {
          reactor.core.publisher.Flux<io.netifi.rsocket.example.SimpleRequest> messages =
            publisher.map(deserializer(io.netifi.rsocket.example.SimpleRequest.parser()));
          return reactor.core.publisher.Flux.defer(() -> reactor.core.publisher.Flux.fromIterable(service.streamingRequestAndResponse(messages.toIterable(), metadata)).map(serializer).transform(streamingRequestAndResponse)).subscribeOn(scheduler);
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
