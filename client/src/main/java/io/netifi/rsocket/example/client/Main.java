package io.netifi.rsocket.example.client;

import io.netifi.rsocket.example.SimpleRequest;
import io.netifi.rsocket.example.SimpleResponse;
import io.netifi.rsocket.example.SimpleServiceClient;
import io.rsocket.RSocket;
import io.rsocket.RSocketFactory;
import io.rsocket.transport.netty.client.TcpClientTransport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reactor.core.publisher.Flux;

public class Main {
  private static final Logger logger = LogManager.getLogger(Main.class);

  public static void main(String... args) {

    RSocket rSocket =
        RSocketFactory.connect().transport(TcpClientTransport.create(8081)).start().block();
    SimpleServiceClient serviceClient = new SimpleServiceClient(rSocket);

    SimpleServiceClient client = new SimpleServiceClient(rSocket);

    Flux<SimpleRequest> requests =
        Flux.range(1, 11)
            .map(i -> "sending -> " + i)
            .map(s -> SimpleRequest.newBuilder().setRequestMessage(s).build());

    SimpleResponse response = client.streamingRequestSingleResponse(requests).block();

    System.out.println(response.getResponseMessage());
  }
}
