package io.netifi.rsocket.example.service;

import io.netifi.rsocket.example.SimpleServiceServer;
import io.rsocket.RSocketFactory;
import io.rsocket.rpc.rsocket.RequestHandlingRSocket;
import io.rsocket.transport.netty.server.CloseableChannel;
import io.rsocket.transport.netty.server.TcpServerTransport;
import reactor.core.publisher.Mono;

import java.util.Optional;

public class Main {

  public static void main(String... args) throws Exception {
    SimpleServiceServer serviceServer = new SimpleServiceServer(new DefaultSimpleService(), Optional.empty(), Optional.empty());
    CloseableChannel closeableChannel =
        RSocketFactory.receive()
            .acceptor(
                (setup, sendingSocket) -> Mono.just(new RequestHandlingRSocket(serviceServer)))
            .transport(TcpServerTransport.create(8081))
            .start()
            .block();
    
    // Block so we don't exit
    closeableChannel.onClose().block();
  }
}
