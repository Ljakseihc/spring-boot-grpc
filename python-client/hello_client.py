import grpc
import hello_pb2
import hello_pb2_grpc

def run():
    channel = grpc.insecure_channel('localhost:8080')
    stub = hello_pb2_grpc.PingPongServiceStub(channel)

    request = hello_pb2.PingRequest(name="Ping")

    response = stub.SayPong(request)
    print(f"Received response: {response.message}")

if __name__ == "__main__":
    run()
