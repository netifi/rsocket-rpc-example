package io.netifi.rsocket.example;

/**
 */
@javax.annotation.Generated(
    value = "by RSocket RPC proto compiler",
    comments = "Source: service.proto")
public interface SimpleService {
  String SERVICE = "io.netifi.rsocket.example.SimpleService";
  String METHOD_REQUEST_REPLY = "RequestReply";
  String METHOD_FIRE_AND_FORGET = "FireAndForget";
  String METHOD_REQUEST_STREAM = "RequestStream";
  String METHOD_STREAMING_REQUEST_SINGLE_RESPONSE = "StreamingRequestSingleResponse";
  String METHOD_STREAMING_REQUEST_AND_RESPONSE = "StreamingRequestAndResponse";

  /**
   * <pre>
   * Request / Response
   * </pre>
   */
  reactor.core.publisher.Mono<io.netifi.rsocket.example.SimpleResponse> requestReply(io.netifi.rsocket.example.SimpleRequest message, io.netty.buffer.ByteBuf metadata);

  /**
   * <pre>
   * Fire-and-Forget
   * </pre>
   */
  reactor.core.publisher.Mono<com.google.protobuf.Empty> fireAndForget(io.netifi.rsocket.example.SimpleRequest message, io.netty.buffer.ByteBuf metadata);

  /**
   * <pre>
   * Single Request / Streaming Response
   * </pre>
   */
  reactor.core.publisher.Flux<io.netifi.rsocket.example.SimpleResponse> requestStream(io.netifi.rsocket.example.SimpleRequest message, io.netty.buffer.ByteBuf metadata);

  /**
   * <pre>
   * Streaming Request / Single Response
   * </pre>
   */
  reactor.core.publisher.Mono<io.netifi.rsocket.example.SimpleResponse> streamingRequestSingleResponse(org.reactivestreams.Publisher<io.netifi.rsocket.example.SimpleRequest> messages, io.netty.buffer.ByteBuf metadata);

  /**
   * <pre>
   * Streaming Request / Streaming Response
   * </pre>
   */
  reactor.core.publisher.Flux<io.netifi.rsocket.example.SimpleResponse> streamingRequestAndResponse(org.reactivestreams.Publisher<io.netifi.rsocket.example.SimpleRequest> messages, io.netty.buffer.ByteBuf metadata);
}
