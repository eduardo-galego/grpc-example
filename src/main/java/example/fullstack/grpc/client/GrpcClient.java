package example.fullstack.grpc.client;

import example.fullstack.grpc.HelloRequest;
import example.fullstack.grpc.HelloResponse;
import example.fullstack.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("Frodo")
                .setLastName("Bolseiro")
                .build());

        System.out.println("Response received from server:\n" + helloResponse);

        channel.shutdown();
    }

}
