package info.kinhho;

import info.kinhho.helloworld.HelloServiceGrpc;
import info.kinhho.helloworld.HelloResponse;
import info.kinhho.helloworld.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws IOException, InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext().build();

        // synchronize service calling
        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);
        HelloResponse response = stub.hello(HelloRequest.newBuilder().setName("Kinh1").build());
        System.out.println(response.getMessage());

        channel.shutdown();
    }
}
