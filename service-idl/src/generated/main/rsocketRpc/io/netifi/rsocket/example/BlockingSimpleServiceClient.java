package io.netifi.rsocket.example;

@javax.annotation.Generated(
    value = "by RSocket RPC proto compiler (version 0.2.12)",
    comments = "Source: service.proto")
@io.rsocket.rpc.annotations.internal.Generated(
    type = io.rsocket.rpc.annotations.internal.ResourceType.CLIENT,
    idlClass = BlockingSimpleService.class)
public final class BlockingSimpleServiceClient implements BlockingSimpleService {
  private final io.netifi.rsocket.example.SimpleServiceClient delegate;

  public BlockingSimpleServiceClient(io.rsocket.RSocket rSocket) {
    this.delegate = new io.netifi.rsocket.example.SimpleServiceClient(rSocket);
  }

  public BlockingSimpleServiceClient(io.rsocket.RSocket rSocket, io.micrometer.core.instrument.MeterRegistry registry) {
    this.delegate = new io.netifi.rsocket.example.SimpleServiceClient(rSocket, registry);
  }

  @io.rsocket.rpc.annotations.internal.GeneratedMethod(returnTypeClass = io.netifi.rsocket.example.SimpleResponse.class)
  public io.netifi.rsocket.example.SimpleResponse requestReply(io.netifi.rsocket.example.SimpleRequest message) {
    return requestReply(message, io.netty.buffer.Unpooled.EMPTY_BUFFER);
  }

  @java.lang.Override
  @io.rsocket.rpc.annotations.internal.GeneratedMethod(returnTypeClass = io.netifi.rsocket.example.SimpleResponse.class)
  public io.netifi.rsocket.example.SimpleResponse requestReply(io.netifi.rsocket.example.SimpleRequest message, io.netty.buffer.ByteBuf metadata) {
    return delegate.requestReply(message, metadata).block();
  }

  @io.rsocket.rpc.annotations.internal.GeneratedMethod(returnTypeClass = com.google.protobuf.Empty.class)
  public com.google.protobuf.Empty fireAndForget(io.netifi.rsocket.example.SimpleRequest message) {
    return fireAndForget(message, io.netty.buffer.Unpooled.EMPTY_BUFFER);
  }

  @java.lang.Override
  @io.rsocket.rpc.annotations.internal.GeneratedMethod(returnTypeClass = com.google.protobuf.Empty.class)
  public com.google.protobuf.Empty fireAndForget(io.netifi.rsocket.example.SimpleRequest message, io.netty.buffer.ByteBuf metadata) {
    return delegate.fireAndForget(message, metadata).block();
  }

  @io.rsocket.rpc.annotations.internal.GeneratedMethod(returnTypeClass = io.netifi.rsocket.example.SimpleResponse.class)
  public  io.rsocket.rpc.BlockingIterable<io.netifi.rsocket.example.SimpleResponse> requestStream(io.netifi.rsocket.example.SimpleRequest message) {
    return requestStream(message, io.netty.buffer.Unpooled.EMPTY_BUFFER);
  }

  @java.lang.Override
  @io.rsocket.rpc.annotations.internal.GeneratedMethod(returnTypeClass = io.netifi.rsocket.example.SimpleResponse.class)
  public  io.rsocket.rpc.BlockingIterable<io.netifi.rsocket.example.SimpleResponse> requestStream(io.netifi.rsocket.example.SimpleRequest message, io.netty.buffer.ByteBuf metadata) {
    reactor.core.publisher.Flux stream = delegate.requestStream(message, metadata);
    return new  io.rsocket.rpc.BlockingIterable<>(stream, reactor.util.concurrent.Queues.SMALL_BUFFER_SIZE, reactor.util.concurrent.Queues.small());
  }

  @io.rsocket.rpc.annotations.internal.GeneratedMethod(returnTypeClass = io.netifi.rsocket.example.SimpleResponse.class)
  public io.netifi.rsocket.example.SimpleResponse streamingRequestSingleResponse(Iterable<io.netifi.rsocket.example.SimpleRequest> messages) {
    return streamingRequestSingleResponse(messages, io.netty.buffer.Unpooled.EMPTY_BUFFER);
  }

  @java.lang.Override
  @io.rsocket.rpc.annotations.internal.GeneratedMethod(returnTypeClass = io.netifi.rsocket.example.SimpleResponse.class)
  public io.netifi.rsocket.example.SimpleResponse streamingRequestSingleResponse(Iterable<io.netifi.rsocket.example.SimpleRequest> messages, io.netty.buffer.ByteBuf metadata) {
    return delegate.streamingRequestSingleResponse(reactor.core.publisher.Flux.defer(() -> reactor.core.publisher.Flux.fromIterable(messages)), metadata).block();
  }

  @io.rsocket.rpc.annotations.internal.GeneratedMethod(returnTypeClass = io.netifi.rsocket.example.SimpleResponse.class)
  public  io.rsocket.rpc.BlockingIterable<io.netifi.rsocket.example.SimpleResponse> streamingRequestAndResponse(Iterable<io.netifi.rsocket.example.SimpleRequest> messages) {
    return streamingRequestAndResponse(messages, io.netty.buffer.Unpooled.EMPTY_BUFFER);
  }

  @java.lang.Override
  @io.rsocket.rpc.annotations.internal.GeneratedMethod(returnTypeClass = io.netifi.rsocket.example.SimpleResponse.class)
  public  io.rsocket.rpc.BlockingIterable<io.netifi.rsocket.example.SimpleResponse> streamingRequestAndResponse(Iterable<io.netifi.rsocket.example.SimpleRequest> messages, io.netty.buffer.ByteBuf metadata) {
    reactor.core.publisher.Flux stream = delegate.streamingRequestAndResponse(reactor.core.publisher.Flux.defer(() -> reactor.core.publisher.Flux.fromIterable(messages)), metadata);
    return new  io.rsocket.rpc.BlockingIterable<>(stream, reactor.util.concurrent.Queues.SMALL_BUFFER_SIZE, reactor.util.concurrent.Queues.small());
  }

}

