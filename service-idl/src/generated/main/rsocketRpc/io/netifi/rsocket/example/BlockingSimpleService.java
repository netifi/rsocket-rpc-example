package io.netifi.rsocket.example;

/**
 */
@javax.annotation.Generated(
    value = "by RSocket RPC proto compiler (version 0.2.12)",
    comments = "Source: service.proto")
public interface BlockingSimpleService {
  String SERVICE_ID = "io.netifi.rsocket.example.SimpleService";
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
  io.netifi.rsocket.example.SimpleResponse requestReply(io.netifi.rsocket.example.SimpleRequest message, io.netty.buffer.ByteBuf metadata);

  /**
   * <pre>
   * Fire-and-Forget
   * </pre>
   */
  com.google.protobuf.Empty fireAndForget(io.netifi.rsocket.example.SimpleRequest message, io.netty.buffer.ByteBuf metadata);

  /**
   * <pre>
   * Single Request / Streaming Response
   * </pre>
   */
  Iterable<io.netifi.rsocket.example.SimpleResponse> requestStream(io.netifi.rsocket.example.SimpleRequest message, io.netty.buffer.ByteBuf metadata);

  /**
   * <pre>
   * Streaming Request / Single Response
   * </pre>
   */
  io.netifi.rsocket.example.SimpleResponse streamingRequestSingleResponse(Iterable<io.netifi.rsocket.example.SimpleRequest> messages, io.netty.buffer.ByteBuf metadata);

  /**
   * <pre>
   * Streaming Request / Streaming Response
   * </pre>
   */
  Iterable<io.netifi.rsocket.example.SimpleResponse> streamingRequestAndResponse(Iterable<io.netifi.rsocket.example.SimpleRequest> messages, io.netty.buffer.ByteBuf metadata);
}
